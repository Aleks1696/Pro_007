package hibernate.lesson09.entity;

public class Maniac {

    private Long id;
    private String name;
    private Integer killScore;
    private String specialisation;

    public Maniac() {
    }

    public Maniac(Long id, String name, Integer killScore, String specialisation) {
        this.id = id;
        this.name = name;
        this.killScore = killScore;
        this.specialisation = specialisation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKillScore() {
        return killScore;
    }

    public void setKillScore(Integer killScore) {
        this.killScore = killScore;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Maniac{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", killScore=").append(killScore);
        sb.append(", specialisation='").append(specialisation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
