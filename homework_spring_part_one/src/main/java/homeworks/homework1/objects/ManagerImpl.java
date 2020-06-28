package homeworks.homework1.objects;

public class ManagerImpl implements Manager{


    private Person person;

    public ManagerImpl(Person person) {
        this.person = person;
    }


    @Override
    public Person getPerson() {
        return person;
    }

}
