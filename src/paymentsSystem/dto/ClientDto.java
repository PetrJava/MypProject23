package paymentsSystem.dto;

public record ClientDto(int limit,
                        int offset,
                        String last_name) {
}
