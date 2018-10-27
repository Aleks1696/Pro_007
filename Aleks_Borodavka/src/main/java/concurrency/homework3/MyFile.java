package concurrency.homework3;

public class MyFile {
    private String name;
    private String extension;


    public MyFile(String name){
        this.name = name;
    }

    public MyFile(String name, String extension){
        this.name = name;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString(){
        return "MyFile found: " + name + "." +  extension;
    }
}
