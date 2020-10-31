package coronavirusexample;
import java.util.*;
class Patient
{
    private String name;
    private int id;
    private String gender;
    private int age;
    private Location address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "name:" + name + ", id:" + id + ", gender:" + gender + ", age:" + age + ", address:" + address;
    }
    
}
class Location
{
    private String province;
    private String district;
    private String taluka;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    @Override
    public String toString() {
        return "province:" + province + ", district:" + district + ", taluka:" + taluka;
    }
    
    
}
class PatientInformation
{
    Patient p=new Patient();
    Location l=new Location();
    Set<Patient> set1=new HashSet<Patient>();
    Set<Location> set2=new HashSet<Location>();
   static Scanner s=new Scanner(System.in);
    public void add()
    {
        Patient p1=new Patient();
        Location l1=new Location();
        
        System.out.println("Enter id");
        int id=s.nextInt();
        p1.setId(id);
        
        System.out.println("Enter Patient name");
        String name=s.next();
        p1.setName(name);
        
        
        
        System.out.println("Enter gender");
        String gender=s.next();
        p1.setGender(gender);
        
        System.out.println("Enter age");
        int age=s.nextInt();
        p1.setAge(age);
        
        System.out.println("***PATIENT ADDRESS***");
        System.out.println();
        System.out.println("Enter Province");
        String province=s.next();
        l1.setProvince(province);
        
        System.out.println("Enter District");
        String district=s.next();
        l1.setDistrict(district);
        
        System.out.println("Enter Taluka");
        String taluka=s.next();
        l1.setTaluka(taluka);
        
        p1.setAddress(l1);
        
    
        set1.add(p1);
        System.out.println("****PATIENT ADDED SUCCESSFULLY****");
        System.out.println();
        System.out.println();
        
        menu();
    }
    
    
    public void showSingle()
    {
        System.out.println("Enter Patient id");
        int id=s.nextInt();
        boolean b=false;
        
        for(Patient i:set1)
        {
            if(i.getId()==id)
            {
                System.out.println(i);
                b=true;
                break;
            }
            else
            {
                b=false;
            }
        }
        if(b==false)
        {
            System.out.println("###PATIENT WITH ID "+id+" DOES NOT EXIST###");
        }
        System.out.println();
        System.out.println();
        menu();
    }
    
    public void show()
    {
        for(Patient p2:set1)
        {
            System.out.println(p2);
        }
        System.out.println();
        System.out.println();
        menu();
    }
    public void delete()
    {
        boolean b=false;
        System.out.println("Enter patient id to delete");
        int id=s.nextInt();
        
        for(Patient i:set1)
        {
            if(i.getId()==id)
            {
                set1.remove(i);
                System.out.println("****PATIENT DATA DELETED SUCCESFULLY****");
                b=true;
                break;
            }
            else
            {
                b=false;
            }
        }
        if(b==false)
        {
            System.out.println("###PATIENT DOES NOT EXIST WITH ID "+id+" ###");
        }
        System.out.println();
        System.out.println();
        menu();
    }
    
    public void districtPatient(String district)
    {
        for(Patient i:set1)
        {
            if(i.getAddress().getDistrict().equals(district))
            {
                System.out.println(i);
            }
        }
        System.out.println();
        System.out.println();
        menu();
    }
    
    
    public void update()
    {
        System.out.println("Enter patiend id to update");
        int id=s.nextInt();
        boolean b=false;
        
        for(Patient i:set1)
        {
            if(i.getId()==id)
            {
                System.out.println("Enter new id");
                int newId=s.nextInt();
                i.setId(newId);
                
                System.out.println("Enter new name");
                String name=s.next();
                i.setName(name);
                b=true;
                System.out.println("****PATIENT UPDATED SUCCESFULLY****");
                break;
            }
            else
            {
                b=false;
            }
        }
        if(b==false)
        {
            System.out.println("###ENTERED ID DOES NOT EXIST###");
        }
        System.out.println();
        System.out.println();
        menu();
    }
    
    
    public void menu()
    {
        System.out.println("Enter 1: Add Patient");
        System.out.println("Enter 2: Delete Patient");
        System.out.println("Enter 3: To get single Patient");
        System.out.println("Enter 4: To get All Patients");
        System.out.println("Enter 5: to get district wise Patient List");
        System.out.println("Enter 6: Update Patient");
        
        
        int n=s.nextInt();
        
        if(n==1)
        {
            add();
        }
        else if(n==2)
        {
            delete();
        }
        else if(n==3)
        {
            showSingle();
        }
        else if(n==4)
        {
            show();
        }
        else if(n==5)
        {
            System.out.println("Enter district name");
            String district=s.next();
            districtPatient(district);
        }
        else if(n==6)
        {
            update();
        }
    }
}

public class CoronaVirusExample {

    public static void main(String[] args) {
        PatientInformation p=new PatientInformation();
        p.menu();
    }
    
}
