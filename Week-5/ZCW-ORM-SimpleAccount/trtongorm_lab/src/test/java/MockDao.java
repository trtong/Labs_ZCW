import com.j256.ormlite.dao.*;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.*;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class MockDao implements Dao {


    @Override
    public Object queryForId(Object o) throws SQLException {
        return null;
    }

    @Override
    public Object queryForFirst(PreparedQuery preparedQuery) throws SQLException {
        return null;
    }

    @Override
    public List queryForAll() throws SQLException {
        return null;
    }

    @Override
    public List queryForEq(String s, Object o) throws SQLException {
        return null;
    }

    @Override
    public List queryForMatching(Object o) throws SQLException {
        return null;
    }

    @Override
    public List queryForMatchingArgs(Object o) throws SQLException {
        return null;
    }

    @Override
    public Object queryForSameId(Object o) throws SQLException {
        return null;
    }

    @Override
    public QueryBuilder queryBuilder() {
        return null;
    }

    @Override
    public UpdateBuilder updateBuilder() {
        return null;
    }

    @Override
    public DeleteBuilder deleteBuilder() {
        return null;
    }

    @Override
    public List query(PreparedQuery preparedQuery) throws SQLException {
        return null;
    }

    @Override
    public int create(Object o) throws SQLException {
        return 500;
    }

    @Override
    public Object createIfNotExists(Object o) throws SQLException {
        return null;
    }

    @Override
    public CreateOrUpdateStatus createOrUpdate(Object o) throws SQLException {
        return null;
    }

    @Override
    public int update(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int updateId(Object o, Object o2) throws SQLException {
        return 0;
    }

    @Override
    public int update(PreparedUpdate preparedUpdate) throws SQLException {
        return 0;
    }

    @Override
    public int refresh(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Collection collection) throws SQLException {
        return 0;
    }

    @Override
    public int deleteIds(Collection collection) throws SQLException {
        return 0;
    }

    @Override
    public int delete(PreparedDelete preparedDelete) throws SQLException {
        return 0;
    }

    @Override
    public CloseableIterator iterator() {
        return null;
    }

    @Override
    public CloseableIterator iterator(int i) {
        return null;
    }

    @Override
    public CloseableIterator iterator(PreparedQuery preparedQuery) throws SQLException {
        return null;
    }

    @Override
    public CloseableIterator iterator(PreparedQuery preparedQuery, int i) throws SQLException {
        return null;
    }

    @Override
    public CloseableWrappedIterable getWrappedIterable() {
        return null;
    }

    @Override
    public CloseableWrappedIterable getWrappedIterable(PreparedQuery preparedQuery) {
        return null;
    }

    @Override
    public void closeLastIterator() throws SQLException {

    }

    @Override
    public GenericRawResults<String[]> queryRaw(String s, String... strings) throws SQLException {
        return null;
    }

    @Override
    public GenericRawResults<Object[]> queryRaw(String s, DataType[] dataTypes, String... strings) throws SQLException {
        return null;
    }

    @Override
    public long queryRawValue(String s, String... strings) throws SQLException {
        return 0;
    }

    @Override
    public int executeRaw(String s, String... strings) throws SQLException {
        return 0;
    }

    @Override
    public int executeRawNoArgs(String s) throws SQLException {
        return 0;
    }

    @Override
    public int updateRaw(String s, String... strings) throws SQLException {
        return 0;
    }

    @Override
    public String objectToString(Object o) {
        return null;
    }

    @Override
    public boolean objectsEqual(Object o, Object t1) throws SQLException {
        return false;
    }

    @Override
    public Object extractId(Object o) throws SQLException {
        return null;
    }

    @Override
    public Class getDataClass() {
        return null;
    }

    @Override
    public boolean isUpdatable() {
        return false;
    }

    @Override
    public boolean isTableExists() throws SQLException {
        return false;
    }

    @Override
    public long countOf() throws SQLException {
        return 0;
    }

    @Override
    public long countOf(PreparedQuery preparedQuery) throws SQLException {
        return 0;
    }

    @Override
    public void assignEmptyForeignCollection(Object o, String s) throws SQLException {

    }

    @Override
    public void setObjectCache(boolean b) throws SQLException {

    }

    @Override
    public void setObjectCache(ObjectCache objectCache) throws SQLException {

    }

    @Override
    public ObjectCache getObjectCache() {
        return null;
    }

    @Override
    public void clearObjectCache() {

    }

    @Override
    public Object mapSelectStarRow(DatabaseResults databaseResults) throws SQLException {
        return null;
    }

    @Override
    public GenericRowMapper getSelectStarRowMapper() throws SQLException {
        return null;
    }

    @Override
    public RawRowMapper getRawRowMapper() {
        return null;
    }

    @Override
    public boolean idExists(Object o) throws SQLException {
        return false;
    }

    @Override
    public DatabaseConnection startThreadConnection() throws SQLException {
        return null;
    }

    @Override
    public void endThreadConnection(DatabaseConnection databaseConnection) throws SQLException {

    }

    @Override
    public void setAutoCommit(boolean b) throws SQLException {

    }

    @Override
    public void setAutoCommit(DatabaseConnection databaseConnection, boolean b) throws SQLException {

    }

    @Override
    public boolean isAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public boolean isAutoCommit(DatabaseConnection databaseConnection) throws SQLException {
        return false;
    }

    @Override
    public void commit(DatabaseConnection databaseConnection) throws SQLException {

    }

    @Override
    public void rollBack(DatabaseConnection databaseConnection) throws SQLException {

    }

    @Override
    public ConnectionSource getConnectionSource() {
        return null;
    }

    @Override
    public void setObjectFactory(ObjectFactory objectFactory) {

    }

    @Override
    public ForeignCollection getEmptyForeignCollection(String s) throws SQLException {
        return null;
    }

    @Override
    public FieldType findForeignFieldType(Class aClass) {
        return null;
    }

    @Override
    public Object callBatchTasks(Callable callable) throws Exception {
        return null;
    }

    @Override
    public GenericRawResults queryRaw(String s, DataType[] dataTypes, RawRowObjectMapper rawRowObjectMapper, String... strings) throws SQLException {
        return null;
    }

    @Override
    public GenericRawResults queryRaw(String s, RawRowMapper rawRowMapper, String... strings) throws SQLException {
        return null;
    }

    @Override
    public List queryForFieldValuesArgs(Map map) throws SQLException {
        return null;
    }

    @Override
    public List queryForFieldValues(Map map) throws SQLException {
        return null;
    }

    @Override
    public CloseableIterator closeableIterator() {
        return null;
    }
}