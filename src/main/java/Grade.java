import lombok.Getter;

@Getter
public enum Grade {
    EXCELLENT(1),
    GOOD(2),
    OKAY(3),
    NOT_SO_OKAY(4),
    FAIL(5),
    BIG_FAIL(6);

    private final int value;
    Grade(int a) {
        value = a;
    }
}
