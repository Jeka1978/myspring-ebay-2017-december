package qualifiers;

import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@Db(Type.MAIN)
public class MongoDao implements Dao {
    @Override
    public void save() {
        System.out.println("saving to Mongo");
    }
}
