package task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();

        Data data = new Data();
        data.setAge(29);
        data.setName("Arthur");
        session.save(data);
        Long id = (Long) session.save(data);

        Data readData = session.get(Data.class, id);
        System.out.println(readData);

        session.beginTransaction();
        data.setAge(12);
        session.update(data);
        session.getTransaction().commit();

        session.delete(readData);
        readData = session.get(Data.class, id);
        System.out.println(readData);

    }
}
