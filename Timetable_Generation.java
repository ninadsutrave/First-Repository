import java.lang.Object;
import java.lang.String;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
/**
 * TIME TABLE GENERATION 
 * An application to store teachers' database
 * Used to manipulate the existing data
 * Used to create a timetable for the school
 **/
public final class Timetable_Generation extends Object
{
    private static InputStreamReader ISR= new InputStreamReader(System.in);
    private static BufferedReader BR= new BufferedReader(ISR);
    private static Random generate= new Random();
    
    private static String clear_screen;
    private static String choice;    
    private static String name[], sex[], blood_group[], date_of_birth[], date_of_joining[], subjects[], email_id[], city[], basic[], mobile_number[];      
    private int employee_code, code;
    private final int length;
    public Timetable_Generation() 
    {
        /** gives in pre defined values to the description feilds **/
        /** does not take any parameters **/
        /** is invoked if user does not want to start with his own values **/ 
        
        this(11);
        name= new String[]{"Amit","Ansh","Ansh","Armaan","Harshal","Jaydeep","Johnny","Lakshya","Nigel","Ninad", "","","","","","","","","",""};
        sex= new String[]{"Male","Male","Male","Male","Male","Male","Male","Male","Male","Male", "","","","","","","","","",""};
        blood_group= new String[]{"A+","B+","O-","B+","A+","O+","A+","AB+","A+","A+", "","","","","","","","","",""};
        date_of_birth= new String[]{"26/01/2001","2/04/2001","11/06/2001","24/3/2001","31/01/2001","31/01/2001","2/12/2001","7/09/2001","31/01/2001","15/04/2001", "","","","","","","","","",""}; 
        date_of_joining= new String[]{"31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016","31/01/2016", "","","","","","","","","",""};;
        subjects= new String[]{"English1","English2","Hindi","Maths","Physics","Chemistry","Biology","History","Geography","Computer Applications", "","","","","","","","","",""};
        email_id= new String[]{"amit@gmail.com","ansh@yahoo.com","ansh@rediffmail.com","armaan@hotmail.com","harshal@rocketmail.com","jaydeep@gmail.com","johnny@yahoo.co.in","lakshya@rediffmail.com","nigel@rocketmail.com","ninad@hotmail.com", "","","","","","","","","",""}; ;
        city= new String[]{"Belapur","Airoli","Kurla","Mulund","Kopar khairane","Ghansoli","Sanpada","Ghatkopar","Thane","Vashi" ,"","","","","","","","","",""};        
        basic= new String[]{"15000","18000","14000","19000","17000","14000","16000","15500","12000","20000", "","","","","","","","","",""};
        mobile_number= new String[]{"9802968472","7734976834","9921051286","9723812895","974807921","9388976832","9020456370","9163768432","9748758362","9769958732", "","","","","","","","","",""};
        
        clear_screen= "\f";
        choice= "";
        employee_code= 11;
        code= 11;
    }
    public Timetable_Generation(int length)
    {
        /** does not fill in any values **/
        /** takes the length of the arrays as the only parameter **/
        /** is invoked if user wishes to start with a fresh set **/    
        
        name= new String[length];
        sex= new String[length];
        blood_group= new String[length];
        date_of_birth= new String[length];
        date_of_joining= new String[length];
        subjects= new String[length];
        email_id= new String[length];
        city= new String[length];
        basic= new String[length];
        mobile_number= new String[length];
        
        this.clear_screen= "\f";
        this.choice= "";
        this.employee_code= 1;
        this.code= 1;
        this.length= length;
    }
    public Timetable_Generation(String name[], String sex[], String blood_group[], String date_of_birth[], String date_of_joining[], String subjects[], String email_id[], String city[], String basic[], String mobile_number[], int subscript)
    { 
        /** inputs starting values from the user **/
        /** takes whole arrays, i.e details of all fields as parameters **/
        /** is invoked only if user wishes to start with his own values **/  
        
        this.name= name;
        this.sex= sex;
        this.blood_group= blood_group;
        this.date_of_birth= date_of_birth;
        this.date_of_joining= date_of_joining;
        this.subjects= subjects;
        this.city= city;
        this.basic= basic;
        this.mobile_number= mobile_number;
        
        clear_screen= "\f";
        choice= "";
        length= name.length;
        employee_code= subscript; 
        code= subscript;
    }    
    public void home() throws InterruptedException, IOException
    {
        /** home screen of the TIMETABLE GENERATION application **/
        /** displays to the user different options to manipulate the data **/
        /** the fifth option is used to generate a timetable **/     
        
        while(true)
        {
            clear_screen();
            System.out.println("HOME SCREEN");
            System.out.println("\nENTER YOUR CHOICE: \n1. ADD \n2. VIEW DETAILS \n3. MODIFY \n4. DELETE \n5. GENERATE TIMETABLE \n6. EXIT");
            choice= BR.readLine();      
            /** a menu of options is displayed and the user's choice is accepted **/
            choose(choice);
        }
    }
    public void choose(String choice) throws IOException, InterruptedException
    {
        /** inteprets the user's choice **/
        /** calls appropraite method based on it **/
        
        switch(choice)
        {
             case "1":  add();   
                        break;
             case "2":  view_details();
                        break;
             case "3":  modify();
                        break;
             case "4":  delete();
                        break;
             case "5":  generate();
                        break;
             case "6":  exit_program();
                        break;
             default:   System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER '1' '2' '3' '4' OR '5' \nCHOOSE ONLY ONE AMONG THESE");
                        System.out.println("RE-ENTER YOUR CHOICE:"); 
                        home();
        }
    }
    public void add() throws InterruptedException, IOException
    {
        /** is invoked when user chooses 1 in the home screen **/
        /** adds a teacher's details to the database **/
        
        while(true)
        {
            System.out.println("LOADING... ");
            clear_screen();
            System.out.println("ADD");
            if(code>length)
            {
                System.out.println(" YOUR DATA BASE IS FULL! "+"\n CANNOT ADD ANY MORE EMPLOYEES! ");
                Thread.sleep(2000);
                break;
            }    
            /** if the number of current employees is full it exits to the home screen showing an error message **/
            
            System.out.println("EMPLOYEE CODE: "+ code);
            /** employee code is automatically allotted **/
            System.out.println("ENTER THE FIELDS GIVEN BELOW:");
            accept_details(code);
            choice= check(choice);
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                Thread.sleep(2000);
                ++code;    
                /** the current employee code is reserved and it moves on to the next **/                
                System.out.println("DETAILS ADDED");
            }
            else if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                re_initialise(code,"");
            decision("ADD");
        }
        back_to_home();
    }
    public void view_details() throws InterruptedException, IOException
    {
        /** is invoked when the user chooses 2 on the home screen **/
        /** it displays the details of required employee **/
        System.out.println("LOADING... ");
        clear_screen();            
        while(true)
        {
            System.out.println("VIEW DETAILS");
            
            System.out.println("ENTER EMPLOYEE CODE:");
            employee_code= Integer.parseInt(BR.readLine());
            if(employee_code<1 || employee_code>(code-1))
            {
               System.out.println("INPUT INVALID! \nNO SUCH EMPLOYEE YET! PLEASE CHECK YOUR NUMBER AGAIN");
               Thread.sleep(2000);  
               continue;
            }
            display_details(employee_code);
            /** details of the employee is displayed **/
            Thread.sleep(2000);
            decision("VIEW DETAILS");
        }
    }
    public void modify() throws InterruptedException, IOException
    {
        /** is invoked when user chooses 3 in the home screen **/
        /** modifies a teacher's already existing details **/
        System.out.println("LOADING... ");
        clear_screen();            
        while(true)
        {
            System.out.println("MODIFY");
            
            System.out.println("ENTER EMPLOYEE CODE:");
            employee_code= Integer.parseInt(BR.readLine());
            if(employee_code<1 || employee_code>(code-1))
            {
               System.out.println("INPUT INVALID! \nNO SUCH EMPLOYEE YET! PLEASE CHECK YOUR NUMBER AGAIN");
               Thread.sleep(2000);  
               continue;
            }
            display_details(employee_code);
            /** details of the employee is displayed **/
            
            System.out.println("Fill in the fields ONLY IF MODIFICATION IS REQUIRED:");
            /** it becomes user friendly as the user does not have to type all the details once more **/
            accept_details(employee_code);
            choice= check(choice);
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                Thread.sleep(2000);
                System.out.println("Changes Have Been Made!");
            }            
            decision("MODIFY");
        }
    }
    public void delete() throws InterruptedException, IOException
    {
        /** is invoked when user chooses 4 in the home screen **/
        /** deletes a teacher's details already existing **/
        System.out.println("LOADING... ");
        clear_screen();            
        while(true)
        {
            System.out.println("DELETE");
            
            System.out.println("ENTER EMPLOYEE CODE:"); 
            employee_code= Integer.parseInt(BR.readLine());
            if(employee_code<1 || employee_code>(code-1))
            {
               System.out.println("INPUT INVALID! \nNO SUCH EMPLOYEE YET! PLEASE CHECK YOUR NUMBER AGAIN");
               Thread.sleep(2000);    
               continue;
            }
            /** details of the employee is displayed **/
            display_details(employee_code);            
            choice= check(choice);        
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                re_initialise(employee_code,"(details deleted)"); 
                /** deletes all the details and re-initialises the values to "" **/
                Thread.sleep(2000);
                System.out.println("DETAILS HAVE BEEN PERMANANTLY DELETED");
            }            
            decision("DELETE");
        }
    }   
    public void generate() throws InterruptedException, IOException
    {
        /** is invoked when user chooses 5 in the home screen **/
        /** generates a time table for the school **/
        
        while(true)
        {
            System.out.println("LOADING... ");
            clear_screen();
            System.out.println("GENERATE TIMETABLE");
            
            System.out.println("1.REGULAR (PRE-DEFINED SETTINGS OF 10 PERIODS AND 5 DAYS) \n2.CUSTOM (YOU CAN WISH TO ALTER THE SETTINGS)");    
            choice= BR.readLine();
        
            switch(choice)
            {
                case "1": regular();
                          break;
                case "2": custom();
                          break;
                default:  System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER '1' OR '2' \nCHOOSE ONLY ONE");
            }
            decision("GENERATE");
        }
    }     
    public void regular() throws InterruptedException, IOException
    {
        /** the user can choose to make a regular timetable **/
        /** creates a timetable with predefined features **/
        
        int days, periods;
        days=5;
        periods= 10;
        String time_table[][]= new String[5][10]; /** 5 working days and 10 periods in each day **/
        while(true)
        {
            System.out.println("DO YOU WANT TO PRINT THE TABLE? {Y/N)");
            choice= BR.readLine();
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                 print_table(days,periods,time_table);
                 break;
            }
            else if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                break;
            else 
                System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER YES OR NO \nINPUT WOULD NOT BE CASE SENSITIVE \nSINGLE CHARACTER PERMITTED");
        }
    }
    public void custom() throws InterruptedException, IOException
    {
        /** the user can choose to make a custom timetable **/
        /** creates a timetable by accepting features from the user **/
        
        int days, count1, periods;
        outer:
        while(true)
        {
            System.out.print("NUMBER OF PERIODS: "); 
            choice= BR.readLine();
            count1=0;
            while(count1<choice.length())
            {
                if(!Character.isDigit(choice.charAt(count1)))
                    break;
                count1++;
            }
            if(count1==choice.length())
                break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR INPUT MUST BE A POSITIVE INTEGER \nTHERE MUST BE NO ALPHABETICAL KEYS OR SPECIAL KEYS");
            continue;
        }
        
        periods= Integer.parseInt(choice);
        
        while(true)
        {
            System.out.println("\nDAYS: \n1. MONDAY TO FRIDAY \n2. MONDAY TO SATURDAY "); 
            choice= BR.readLine();
            if(choice.equals("1"))
            {
               days= 5;
               break;
            }
            else if(choice.equals("2"))
            {
               days= 6;
               break;
            }
            else 
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR INPUT IS EITHER '1' OR '2' \nCHOOSE ONLY ONE AMONG THESE");
                continue;
            }        
        }
        
        String time_table[][]= new String[days][periods];
        
        while(true)
        {
            System.out.println("DO YOU WANT TO PRINT THE TABLE? {Y/N)");
            choice= BR.readLine();
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                 print_table(days,periods,time_table);
                 break;
            }
            else if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                break;
            else 
                System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER YES OR NO \nINPUT WOULD NOT BE CASE SENSITIVE \nSINGLE CHARACTER PERMITTED");
        }
    }
    public void print_table(int days, int periods, String time_table[][]) throws IOException, InterruptedException
    {
        /** prints the table displaying it to the user **/
        /** accepts the number rows, columns and the timetable array *x */ /** 8,8,5,5,7,9,7,7,9,9 **/
        
        String[] topic= new String[]{"ENGLISH1","ENGLISH2","HINDI","MATHS","PHYSICS","CHEMISTRY","BIOLOGY","HISTORY","GEOGRAPHY","COMPUTERS"};
        String[] day= new String[]{"MONDAY:    ","TUESDAY:   ","WEDNESDAY: ","THURDAY:   ","FRIDAY:    ","SATURDAY:  "};
        outer:
        while(true)
        {
            int count1=0;
            int count2=0;
            int temp, num;
            String lines= "      |"; 
            while(count1<days)
            {
                num= generate.nextInt(topic.length-1);
                temp=num;
                count2=0;
                System.out.print(day[count1]);
                while(count2<periods)
                {
                    time_table[count1][count2]= topic[temp]; 
                    System.out.print(time_table[count1][count2]+lines.substring((topic[temp]).length()-5)+"   ");
                    count2++;
                    if(temp<(topic.length-1))
                        temp++;
                    else 
                        temp= generate.nextInt(topic.length-1);
                }
                System.out.println();
                count1++;            
            }
            choice= check(choice);
            if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
            {
                System.out.println("GENERATING ANOTHER ONE:");
                Thread.sleep(1500);
                continue outer;
            }
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
            {
                 /*** Table is saved ***/
                 Thread.sleep(2000);
                 System.out.println("TIME TABLE HAS BEEN SAVED!");
            }
            break;
        }         
    }
    public String name(int code) throws IOException
    {
        /** checks if the name is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("FULL NAME: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isLetter(input.charAt(count1)) && !input.equals("") && input.charAt(count1)!=' ')
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY APLABETICAL KEYS MUST BE INPUT! \nTHERE ARE NO SPECIAL OR NUMERICAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return name[code -1];
        else 
              return input;
    }
    public String sex(int code) throws IOException
    {
        /** checks if the sex is valid or not **/
        
        String input;
        while(true)
        {
            System.out.print("\nSEX: "); input= BR.readLine();
            if(input.equalsIgnoreCase("M") || input.equalsIgnoreCase("F") || input.equalsIgnoreCase("Male") || input.equalsIgnoreCase("Female") || input.equals(""))
                break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR INPUT MUST EITHER BE: \nMALE or \nFEMALE \nONLY APLABETICAL KEYS MUST BE INPUT \nTHERE ARE NO SPECIAL OR NUMERICAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return sex[code -1];
        else 
              return input;
    }
    public String blood_group(int code) throws IOException
    {
        /** checks if the blood group is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nBLOOD GROUP: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isLetter(input.charAt(count1)) && !input.equals("") && input.charAt(count1)!='+' && input.charAt(count1)!='-')
                    break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY APLABETICAL KEYS MUST BE INPUT \nTHERE ARE NO NUMERICAL OR SPECIAL CHARACTERS (other than + and -)");
            continue;
        }
        if(input.equals(""))
              return blood_group[code -1];
        else 
              return input;
    }
    public String date_of_birth(int code) throws IOException
    {
        /** checks if the date of birth is valid or not **/
        
        String input;
        int day, month, year;
        while(true)
        {
            int count1=0;
            System.out.print("\nDATE OF BIRTH: (DD/MM/YYYY)"); input= BR.readLine();
            if(!Character.isDigit(input.charAt(0)) && !Character.isDigit(input.charAt(1)) && !Character.isDigit(input.charAt(3)) && !Character.isDigit(input.charAt(4)) && !Character.isDigit(input.charAt(6)) && !Character.isDigit(input.charAt(7)) && !Character.isDigit(input.charAt(8)) && !Character.isDigit(input.charAt(9)) )
            {    
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            } 
            if(input.charAt(2)!= '/' && input.charAt(4)!= '/')
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            day= Integer.parseInt(input.substring(0,2));
            month= Integer.parseInt(input.substring(3,5));
            year= Integer.parseInt(input.substring(6));
            
            if(day>31 || day<1 || month>12 || month<1 || year>2017 || year<1)
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            if((day>30) && ((month!=1 && month!=3 && month!=5 && month!=7 && month!=8 && month!= 10 && month!=12)))
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            break;
        }
        if(input.equals(""))
              return date_of_birth[code -1];
        else 
              return input;
    }
    public String date_of_joining(int code) throws IOException
    {
        /** checks if the date of joining is valid or not **/
        
        String input;
        int day, month, year;
        while(true)
        {
            int count1=0;
            System.out.print("\nDATE OF JOINING: (DD/MM/YYYY)"); input= BR.readLine();
            if(!Character.isDigit(input.charAt(0)) && !Character.isDigit(input.charAt(1)) && !Character.isDigit(input.charAt(3)) && !Character.isDigit(input.charAt(4)) && !Character.isDigit(input.charAt(6)) && !Character.isDigit(input.charAt(7)) && !Character.isDigit(input.charAt(8)) && !Character.isDigit(input.charAt(9)) )
            {    
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            } 
            if(input.charAt(2)!= '/' && input.charAt(4)!= '/')
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            day= Integer.parseInt(input.substring(0,2));
            month= Integer.parseInt(input.substring(3,5));
            year= Integer.parseInt(input.substring(6));
            
            if(day>31 || day<1 || month>12 || month<1 || year>2017 || year<1)
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            if((day>30) && ((month!=1 && month!=3 && month!=5 && month!=7 && month!=8 && month!= 10 && month!=12)))
            {
                System.out.println("INPUT INVALID! \nENSURE THAT: \nTHE (DD/MM/YYYY) FORMAT MUST BE PRECISELY FOLLOWED \nTHERE ARE NO ALPHABETIC OR SPECIAL CHARACTERS (other than /) \nPLEASE CHECK IF THERE IS ANY VALUE ERROR");
                continue;
            }
            break;
        }
        if(input.equals(""))
              return date_of_joining[code -1];
        else 
              return input;
    }
    public String subjects(int code) throws IOException
    {
        /** checks if the subject is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nSUBJECT: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isLetter(input.charAt(count1)) && !input.equals("") && input.charAt(count1)!=' ')
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY APLABETICAL KEYS MUST BE INPUT \nTHERE ARE NO SPECIAL OR NUMERICAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return subjects[code -1];
        else 
              return input;  
    }
    public String basic(int code) throws IOException
    {
        /** checks if the salary is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nBASIC: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isDigit(input.charAt(count1)) && !input.equals(""))
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY NUMERICAL KEYS MUST BE INPUT \nTHERE MUST BE NO COMMAS SEPERATING THE DIGITS \nTHERE MUST BE NO SPECIAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return basic[code -1];
        else 
              return input;
    }
    public String email_id(int code) throws IOException
    {
        /** checks if the email id is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nEMAIL ID: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isLetterOrDigit(input.charAt(count1)) && ((input.charAt(count1)!='@') && (input.charAt(count1) != '.') && (input.charAt(count1) != '-') && (input.charAt(count1) != '_') && (input.charAt(count1) != '~') && (!input.equals(""))))
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY ALPHANUMERICAL CHARACTERS AND SOME SPECIAL CHARACTERS ARE INPUT \nTHERE MUST BE NO SPECIAL CHARACTERS OTHER THAN '@' '.' '_' '-' '~' \nNO WHITE SPACES");
            continue;
        }
        if(input.equals(""))
              return email_id[code -1];
        else 
              return input;  
    }
    public String city(int code) throws IOException
    {
        /** checks if the city name is valid or not **/
        
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nCITY: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isLetter(input.charAt(count1)) && !input.equals("") && input.charAt(count1)!=' ')
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVAID! \nENSURE THAT: \nONLY APLABETICAL KEYS MUST BE INPUT \nTHERE MUST BE NO SPECIAL OR NUMERICAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return city[code -1];
        else 
              return input;
    }
    public String mobile_number(int code) throws IOException
    {
        /** checks if the mobile number is valid or not **/
         
        String input;
        while(true)
        {
            int count1=0;
            System.out.print("\nCONTACT NUMBER: "); input= BR.readLine();
            while(count1<input.length())
            {
                if(!Character.isDigit(input.charAt(count1)) && !input.equals(""))
                     break;
                count1++;
            }
            if(count1==input.length())
               break;
            System.out.println("INPUT INVALID! \nENSURE THAT: \nONLY NUMERICAL KEYS MUST BE INPUT \nTHERE ARE NO SPECIAL CHARACTERS");
            continue;
        }
        if(input.equals(""))
              return mobile_number[code -1];
        else 
              return input;
    }
    public void accept_details(int code) throws IOException
    {
        /** accepts the details of the teacher from the user **/
        /** takes the employee code as a parameter **/
        /** the employee code acts as the index of the array to connect between different fields **/
        
                   name[code -1]=    name(code);
                    sex[code -1]=    sex(code); 
            blood_group[code -1]=    blood_group(code);
          date_of_birth[code -1]=    date_of_birth(code);
        date_of_joining[code -1]=    date_of_joining(code);
               subjects[code -1]=    subjects(code);
                  basic[code -1]=    basic(code);
               email_id[code -1]=    email_id(code);
                   city[code -1]=    city(code);
          mobile_number[code -1]=    mobile_number(code);     
    }
    public void display_details(int code) throws InterruptedException
    {
        /** displays the details of the teacher **/
        /** takes the employee code as a parameter **/
        /** the employee code acts as the index of the array to connect between different fields **/
        
        Thread.sleep(2000);
        System.out.println("_________________________________________________");
        System.out.println(           "NAME: "+    name[code -1]);
        System.out.println(            "SEX: "+    sex[code -1]);
        System.out.println(    "BLOOD GROUP: "+    blood_group[code -1]);
        System.out.println(  "DATE OF BIRTH: "+    date_of_birth[code -1]);
        System.out.println("DATE OF JOINING: "+    date_of_joining[code -1]);
        System.out.println(       "SUBJECTS: "+    subjects[code -1]);
        System.out.println(          "BASIC: "+    basic[code -1]);
        System.out.println(       "EMAIL ID: "+    email_id[code -1]);
        System.out.println(        "ADDRESS: "+    city[code -1]);
        System.out.println(  "MOBILE NUMBER: "+    mobile_number[code -1]);
        System.out.println("_________________________________________________");
    }
    public void re_initialise(int code, String choice)
    {
        /** re-initialises the values to "(details deleted)" **/
        /** takes the employee code as a parameter **/
        /** the employee code acts as the index of the array to connect between different fields **/
        
                   name[code -1]=   choice;
                    sex[code -1]=   choice;
            blood_group[code -1]=   choice;
          date_of_birth[code -1]=   choice;
        date_of_joining[code -1]=   choice;
               subjects[code -1]=   choice;
                  basic[code -1]=   choice;
               email_id[code -1]=   choice;
                   city[code -1]=   choice;
          mobile_number[code -1]=   choice;
    }
    public String check(String choice) throws IOException
    {
        /** to accept the user's choice to whether proceed with given command or not **/
        /** returns the user's choice **/
        
        while(true)
        {
             System.out.println("DO YOU WANT TO CONTINUE WITH IT? (Y/N)");
             choice= BR.readLine();
             if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                  break;
             else
             {
                 System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER YES OR NO \nINPUT WOULD NOT BE CASE SENSITIVE \nSINGLE CHARACTER PERMITTED");
                 continue;
             }
        } 
        return choice;
    }
    public void decision(String word) throws IOException, InterruptedException
    {
          /** to accept the user's decision to again do it or not **/
          
          while(true)
          {
              System.out.println("1."+word+ " AGAIN \n2.BACK to HOME SCREEN \n3.EXIT");
              choice= BR.readLine();
              if(choice.equals("1"))
                  ;
              else if(choice.equals("2"))
                  back_to_home();
              else if(choice.equals("3"))
                  exit_program();
              else
              {
                  System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR INPUT MUST BE EITHER '1', '2' OR '3' \nCHOOSE ONLY ONE AMONG THESE");
                  continue;
              }
              break;
          }
    }
    public void back_to_home() throws InterruptedException, IOException
    {
        /** brings the user back to the home screen of the application **/
        /** the user can then exit or again wish to manipulate the data again **/
        
        System.out.println("GOING BACK TO HOME SCREEN..."); 
        Thread.sleep(2000);
        home();
    }
    public void clear_screen() throws InterruptedException
    {
        /** clears whatever is there on the screen at present **/
        /** gives an attractive heading to the application **/
        Thread.sleep(2000);
        System.out.print(clear_screen);
        System.out.println("------------------------------------------------------------------");
        System.out.println("|****************************************************************|");
        System.out.println("|*|------------------------------------------------------------|*|");
        System.out.println("|*| T  I  M  E  T  A  B  L  E     G  E  N  E  R  A  T  I  O  N |*|");
        System.out.println("|*|------------------------------------------------------------|*|");
        System.out.println("|****************************************************************|");
        System.out.println("------------------------------------------------------------------");
    }
    public void exit_program() throws InterruptedException
    {
        /** used to exit the application **/
        /** the user has finished all manipulation of the details **/
        
        System.out.println("EXITING PROGRAM...");
        System.out.println(clear_screen);
        System.exit(0);
    }
    public static void main(String args[]) throws InterruptedException, IOException
    {
        /** main method **/
        /** invokes the appropriate constructor based upon the user's choice **/
        
        /** if user chooses pre defined values default constructor is invoked
         *  if user chooses to have a fresh set first parameterised constructor is invoked
         *  if user chooses to have his own starting vales the second parametrised constructor is invoked
         */  
        
        System.out.println("WELCOME TO \"TIMETABLE GENERATION\"!! \nIT IS AN APPLICATION TO STORE AND MANAGE A TEACHER'S DATABASE \nIT CAN BE USED TO MANIPULATE DATA AS AND WHEN THE NECCESITY ARISES \nIT ALSO DESIGNS A CONVENIENT TIMETABLE FOR THE TEACHERS/STUDENTS");
        System.out.println("\n \nYOU CAN  CHOOSE TO START OFF WITH A DUMMY DATABASE TO UNDERSTAND THE WORKING \nYOU CAN EVEN START WITH A FRESH SET OR IMMEDIATELY START ENTERING YOUR VALUES..... \n \n \n");
        int limit;
        Thread.sleep(8000);
        while(true)
        {
             System.out.println("DO YOU WISH TO START WITH YOUR OWN VALUES? (Y/N)");
             choice= BR.readLine();
             if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                  break;
             else
             {
                  System.out.println("INPUT INVALID! ENSURE THAT: \nYOUR ANSWER IS EITHER YES OR NO \nINPUT WOULD NOT BE CASE SENSITIVE \nSINGLE CHARACTER PERMITTED");
                  continue;
             }
        }
        int subscript=0;
        if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
        {  
            while(true)
            {
                int count1=0;
                System.out.println("ENTER MAXIMUM NUMBER OF EMPLOYEES");
                choice= BR.readLine();
                while(count1<choice.length())
                {
                    if(!Character.isDigit(choice.charAt(count1)))
                         break;
                    count1++;
                }
                if(count1==choice.length())
                    break;
                System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR INPUT CONTAINS ONLY NUMERICAL CHARACTERS");
                continue;
            }
            limit= Integer.parseInt(choice);            
            /** variable limit sets the limit of all the arrays **/
            Timetable_Generation T= new Timetable_Generation(limit);        
            while(subscript<limit)
            {
                System.out.print("\f");
                System.out.println("ENTER:");
                System.out.println("EMPLOYEE CODE: "+(subscript+1));
                
                /** accepts starting values entered by the user **/
                           name[subscript -1]=    T.name(subscript);
                            sex[subscript -1]=    T.sex(subscript); 
                    blood_group[subscript -1]=    T.blood_group(subscript);
                  date_of_birth[subscript -1]=    T.date_of_birth(subscript);
                date_of_joining[subscript -1]=    T.date_of_joining(subscript);
                       subjects[subscript -1]=    T.subjects(subscript);
                          basic[subscript -1]=    T.basic(subscript);
                       email_id[subscript -1]=    T.email_id(subscript);
                           city[subscript -1]=    T.city(subscript);
                  mobile_number[subscript -1]=    T.mobile_number(subscript);
                
                while(true)
                {
                    System.out.println("NEXT? (Y/N)");
                    choice= BR.readLine();
                    if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                        break;
                    else
                    {
                        System.out.println("INPUT INVALID! ENSURE THAT: \nYOUR ANSWER IS EITHER YES OR NO \nINPUT WOULD NOT BE CASE SENSITIVE \nSINGLE CHARACTER PERMITTED");
                        continue;
                    }
                }                    
                Thread.sleep(2000);
                if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"))
                     subscript++;  
                else if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
                     break;         /** user can have any number of starting values but not more than the limit mentioned **/ 
            }
            /** the details accepted are passed on to the second parameterised constructor **/
            Timetable_Generation TT= new Timetable_Generation(name, sex, blood_group, date_of_birth, date_of_joining, subjects, email_id, city, basic, mobile_number, subscript);
            System.out.println("OPENING TIMETABLE_GENERATION ...");
            Thread.sleep(2000);
            TT.home();
        }
        else if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO"))
        {
            while(true)
            {
                System.out.println("DO YOU WISH TO START WITH: \n1. A FRESH SET \n2. PRE-DEFINED VALUES");
                choice= BR.readLine();
                if(choice.equals("1"))
                {
                    System.out.println("ENTER MAXIMUM NUMBER OF EMPLOYEES:");
                    choice= BR.readLine();
                    limit= Integer.parseInt(choice);
                    /** variable length sets the limit of all the arrays **/               
                
                    Timetable_Generation TT= new Timetable_Generation(limit);
                    System.out.println("OPENING TIMETABLE_GENERATION ...");
                    Thread.sleep(2000);
                    TT.home();
                }
                else if(choice.equals("2"))
                {
                    Timetable_Generation TT= new Timetable_Generation();
                    System.out.println("OPENING TIMETABLE_GENERATION ...");
                    Thread.sleep(2000);
                    TT.home();
                }
                else
                {
                    System.out.println("INPUT INVALID! \nENSURE THAT: \nYOUR ANSWER IS EITHER '1' OR '2' \nCHOOSE ONLY ONE AMONG THESE");
                    continue;
                }
            }
        }
    }
}