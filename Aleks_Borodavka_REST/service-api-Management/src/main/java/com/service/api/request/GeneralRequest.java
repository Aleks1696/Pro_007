package com.service.api.request;

public class GeneralRequest<S, T> {

    private S id;
    private T parameters;

    public GeneralRequest() {

    }

    public GeneralRequest(S firstParametr, T secondParamentr) {
        this.id = firstParametr;
        this.parameters = secondParamentr;
    }

    public S getId() {
        return id;
    }

    public void setId(S id) {
        this.id = id;
    }

    public T getParameters() {
        return parameters;
    }

    public void setParameters(T parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeneralRequest{");
        sb.append("id=").append(id);
        sb.append(", parameters=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}
