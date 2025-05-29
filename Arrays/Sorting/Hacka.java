import java.time.Instant;
import java.time.Duration;
import java.util.*;

public class Hacka {
    static class User {
        Deque<Instant> failureTimestamps = new ArrayDeque<>();
        boolean lockedOut = false;
        Instant lockoutEnd = Instant.MIN;
        boolean suspended = false;
    }

    static class IP {
        Deque<Instant> failureTimestamps = new ArrayDeque<>();
        boolean blacklisted = false;
        Instant blacklistEnd = Instant.MIN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, User> users = new HashMap<>();
        Map<String, IP> ips = new HashMap<>();
        List<String> violations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] logEntry = scanner.nextLine().split(" ");
            String timestampStr = logEntry[0];
            String username = logEntry[1];
            String ipAddress = logEntry[2];
            String accessResult = logEntry[3];

            Instant timestamp = Instant.parse(timestampStr);

            users.putIfAbsent(username, new User());
            ips.putIfAbsent(ipAddress, new IP());

            User user = users.get(username);
            IP ip = ips.get(ipAddress);

            // Check for suspension violations
            if (user.suspended) {
                violations.add("SUSPENSION_VIOLATION " + timestampStr + " " + username + " " + ipAddress);
                continue;
            }

            if (user.lockedOut && timestamp.isBefore(user.lockoutEnd)) {
                violations.add("LOCKOUT_VIOLATION " + timestampStr + " " + username + " " + ipAddress);
                continue;
            }

            if (ip.blacklisted && timestamp.isBefore(ip.blacklistEnd)) {
                violations.add("BLACKLIST_VIOLATION " + timestampStr + " " + username + " " + ipAddress);
                continue;
            }

            if (accessResult.equals("FAILURE")) {
                // Handle user lockout policy
                user.failureTimestamps.addLast(timestamp);
                while (!user.failureTimestamps.isEmpty() && Duration.between(user.failureTimestamps.peekFirst(), timestamp).getSeconds() > 300) {
                    user.failureTimestamps.pollFirst();
                }
                if (user.failureTimestamps.size() >= 3) {
                    user.lockedOut = true;
                    user.lockoutEnd = timestamp.plusSeconds(300);
                }

                // Handle IP blacklist policy
                ip.failureTimestamps.addLast(timestamp);
                while (!ip.failureTimestamps.isEmpty() && Duration.between(ip.failureTimestamps.peekFirst(), timestamp).getSeconds() > 1200) {
                    ip.failureTimestamps.pollFirst();
                }
                if (ip.failureTimestamps.size() >= 5) {
                    ip.blacklisted = true;
                    ip.blacklistEnd = timestamp.plusSeconds(1800);
                }

                // Handle account suspension policy
                Deque<Instant> allFailures = user.failureTimestamps;
                long dailyFailures = allFailures.stream().filter(t -> Duration.between(t, timestamp).toDays() < 1).count();
                if (dailyFailures >= 10) {
                    user.suspended = true;
                }
            } else if (accessResult.equals("SUCCESS")) {
                // Reset user failure count and lockout status
                user.failureTimestamps.clear();
                user.lockedOut = false;
            }
        }

        // Output the violations
        if (violations.isEmpty()) {
            System.out.println("NO_VIOLATION");
        } else {
            violations.forEach(System.out::println);
        }
    }
}