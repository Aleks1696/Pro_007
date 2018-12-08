package com.service.api.request.parameters;


public class GroupParametrs {

    private String title;
    private Long courseId;
    private String beginDate;
    private String endDate;

    public GroupParametrs() {

    }

    public GroupParametrs(String title, Long courseId,
                          String beginDate, String endDate) {
        this.title = title;
        this.courseId = courseId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupParametrs{");
        sb.append("title='").append(title).append('\'');
        sb.append(", courseId=").append(courseId);
        sb.append(", beginDate='").append(beginDate).append('\'');
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
