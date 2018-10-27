package hibernate.lesson9.entity;

public class Maniac {
    private Long id;
    private String name;
    private Integer killScore;
    private String specialization;

    public Long getId() {
        return id;
    }

    public Maniac setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Maniac setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getKillScore() {
        return killScore;
    }

    public Maniac setKillScore(Integer killScore) {
        this.killScore = killScore;
        return this;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Maniac setSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Maniac{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", killScore=").append(killScore);
        sb.append(", specialization='").append(specialization).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Maniac(Long id, String name, Integer killScore, String specialization) {
        this.id = id;
        this.name = name;
        this.killScore = killScore;
        this.specialization = specialization;
    }
}
