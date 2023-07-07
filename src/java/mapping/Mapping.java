package mapping;

 sprint4
public class Mapping{
    String ClassName ;
    String Method;
    
    public Mapping(String classeName , String method){
        this.ClassName=classeName;
        this.Method=method;
    }

    public String getClassName(){
        return this.ClassName;
    }
    public void setClassName( String classeName){
        this.ClassName=classeName;
    }
    public String getMethod(){
        return this.Method;
    }
    public void setMethod( String Method){
        this.ClassName=Method;
    }


public class Mapping {
    String className;
    String Method;

    public Mapping(String className, String Method) {
        this.className = className;
        this.Method = Method;
    }

    public Mapping() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }
    
    