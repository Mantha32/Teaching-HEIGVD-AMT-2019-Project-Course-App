package ch.heigvd.amt.schedule.model;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Title {
    private String name;
}
