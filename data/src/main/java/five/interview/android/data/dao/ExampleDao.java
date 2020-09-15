package five.interview.android.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import five.interview.android.data.dao.entity.ExampleDbModel;

import java.util.List;

@Dao
public interface ExampleDao {

    @Query("SELECT * FROM exampledbmodel WHERE id = :id")
    ExampleDbModel getById(int id);


    @Query("SELECT * FROM exampledbmodel WHERE name LIKE :name")
    ExampleDbModel getByName(String name);

    @Query("SELECT * FROM exampledbmodel")
    List<ExampleDbModel> getAll();

    @Insert
    void insert(ExampleDbModel model, ExampleDbModel... models);

    @Query("DELETE FROM exampleDbModel")
    void deleteAll();
}
