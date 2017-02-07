package yang.hong3.com.administrativedivision.address;

/**
 * Created by hong3 on 2016/12/10.
 */

public class CityBean {

    /**
     * id : 110000
     * name : 北京
     * fullname : 北京市
     * pinyin : ["bei","jing"]
     * location : {"lat":39.90469,"lng":116.40717}
     * cidx : [0,15]
     */

    private int id;
    private String fullname;
    private int parentId;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
