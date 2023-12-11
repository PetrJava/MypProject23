package myProject.dto;

public record ClientFilter(int limit,
                           int offset,
                           String last_name) {
}
