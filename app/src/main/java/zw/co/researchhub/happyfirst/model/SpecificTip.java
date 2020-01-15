package zw.co.researchhub.happyfirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName="specific_tips")
public class SpecificTip implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int spec_tip_id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;

    @ColumnInfo(name ="guest_viewed")
    private Boolean viewed;

//    @Embedded(prefix = "mylist_array") private ArrayList<MyListItems> myListItems;


    public int getSpec_tip_id() {
        return spec_tip_id;
    }

    public void setSpec_tip_id(int spec_tip_id) {
        this.spec_tip_id = spec_tip_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }
}

