package task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
        // Create
        Session session = HybernateManager.getSessionFactory().openSession();

        Data data = new Data();
        data.setAge(29);
        data.setName("Arthur");
        session.save(data);
        Long id = (Long) session.save(data);

        // Read
        Data readData = session.get(Data.class, id);
        System.out.println(readData);

        // Update
        session.beginTransaction();
        data.setAge(12);
        session.update(data);
        session.getTransaction().commit();

        // Delete
        session.delete(readData);
        readData = session.get(Data.class, id);
        System.out.println(readData);

    }
}
