package zw.co.researchhub.happyfirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName="user")
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int user_id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="password")
    private String content;

    @ColumnInfo(name ="role")
    private String role;

    @ColumnInfo(name="teacher_id")
    private int teacher_id;

    @ColumnInfo(name="parent_id")
    private int parent_id;

    @ColumnInfo(name="is_going")
    private int isGoing;

//    @Embedded(prefix = "mylist_array") private ArrayList<MyListItems> myListItems;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getIsGoing() {
        return isGoing;
    }

    public void setIsGoing(int isGoing) {
        this.isGoing = isGoing;
    }
}

