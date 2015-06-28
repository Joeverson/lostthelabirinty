package DAODb4o;

public interface DAOInterface<T> {
	public void create(T obj);
	public T read(Object chave) throws Exception;
	public T update(T obj);
	public void delete(T obj) ;
	public void refresh(T obj);
}