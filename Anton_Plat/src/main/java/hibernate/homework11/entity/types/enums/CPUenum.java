package hibernate.homework11.entity.types.enums;

public class CPUenum {
    public CPUenum() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CPUenum{");
        sb.append('}');
        return sb.toString();
    }

    enum CPU{ INTEL,AMD };
}

