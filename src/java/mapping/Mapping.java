package mapping;

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

}