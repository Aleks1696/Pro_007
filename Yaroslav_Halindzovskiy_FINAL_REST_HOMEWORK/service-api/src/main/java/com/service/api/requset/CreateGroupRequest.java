package com.service.api.requset;

public class CreateGroupRequest {
    private String begindata;
    private Long courseId;
    private String endDate;
    private String title;

    public String getBegindata() {
        return begindata;
    }

    public void setBegindata(String begindata) {
        this.begindata = begindata;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateGroupRequest{");
        sb.append("begindata='").append(begindata).append('\'');
        sb.append(", courseId=").append(courseId);
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
