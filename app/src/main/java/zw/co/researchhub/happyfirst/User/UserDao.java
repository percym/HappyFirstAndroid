package zw.co.researchhub.happyfirst.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import zw.co.researchhub.happyfirst.CONSTANTS;
import zw.co.researchhub.happyfirst.model.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM "+ CONSTANTS.USER_TIPS_TABLE)
    LiveData<List<User>> getAll();


    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(User user);

    /*
     * update the object in database
     * @param note, object to be updated
     */
    @Update
    void update(User user);

    /*
     * delete the object from database
     * @param note, object to be deleted
     */
    @Delete
    void delete(User user);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(User... users);      // User... is varargs, here note is an array


    @Query("SELECT * FROM " + CONSTANTS.USER_TIPS_TABLE +  " WHERE user_id = :id")
    public User getUserById(Long id);

    @Query("SELECT * FROM " + CONSTANTS.USER_TIPS_TABLE +  " WHERE name = :username and password = :pass")
    public User getUserByNameAndPassword(String username , String pass);


    @Query("DELETE FROM " + CONSTANTS.USER_TIPS_TABLE)
    void deleteAll();

    @Query("SELECT * FROM " + CONSTANTS.USER_TIPS_TABLE +  " WHERE role = :role ")
    public LiveData<List<User>> getUserByRole(String role );



}
