import java.util.*;

class Instructor {
    String InstructorName ;
}

class Student {
    String StudentName ;
    boolean [] assignment_done =  new boolean[25] ;
    boolean [] quiz_done = new boolean[25] ;
    submitted_assignments[] graded_ass_obj = new submitted_assignments[25];
    submitted_quizzes[] graded_quiz_obj = new submitted_quizzes[25];

}
class submitted_assignments {
    boolean graded ;
    int assignment_marks ;
    String  file_name  ;
    String  InsName  ;
}

class submitted_quizzes {
    int  quiz_marks ;
    String  quiz_answers ;
    String  quizName  ;
    boolean graded ;
}

class LectureSlide {
    String SlideTitle ;
    int SlideNum ;
    String [] SlideContent = new String[SlideNum] ;
    String Slidedate ;
    String InsName ;

}

class LectureVideo {
    String VideoTitle;
    String VideoFile ;
    String Videodate ;
    String InsName ;

}

class Quizzes {
    String question ;
    boolean quizcheckopen ;
    int marks ;
    public void assign(String qu) {
        this.question = qu ;
        this.marks = 1 ;
        quizcheckopen = true ;
    }
}

class Assignment {
    String problem ;
    int maxmarks ;
    boolean asscheckopen ;

    public void assign(String pr, int marks) {
        this.problem = pr ;
        this.maxmarks = marks ;
        asscheckopen = true ;
    }
}

class DiscussionForum {
    String comment ;
    String name ;
    String time ;
}

interface inter {
        Instructor[] insobj = new Instructor[100] ;
        Student[] stud = new Student[100] ;
        Quizzes[] quizobj = new Quizzes[50] ;
        Assignment[] assobj = new Assignment[50] ;
        LectureSlide[] lecobj = new LectureSlide[30] ;
        LectureVideo[] vidobj = new LectureVideo[30] ;
        DiscussionForum[] cmnt = new DiscussionForum[50] ;
        void askforid() ;
        void askforid(int n) ;
        void viewLectureMaterials() ;
        void viewAssessments() ;
        void viewComments() ;
        void addComments(Instructor obj) ;
        void addComments(Student obj) ;

        }

class Backpack implements inter{
    Scanner sc = new Scanner(System.in) ;
    int chosenins ; //the chosen instructor
    int chosenstud ; //the chosen student


    int quiznum = 0 ; //number of quiz questions
    int assnum = 0 ; //number of assignment questions
    int lcount ;
    int vcount ;
    int cmntcount = 0 ; //number of comments



    //Asking for the instructor id
    public void askforid() {
        System.out.println("""
                0 - I0
                1 - I1""");
        System.out.print("Choose id: ");
        chosenins = sc.nextInt() ;
        //creating instructor objects
        if (insobj[chosenins] == null) {
            if (chosenins==0){
                insobj[chosenins] = new Instructor() ;
                insobj[chosenins].InstructorName = "IO" ;
            }
            else if (chosenins==1) {
                insobj[chosenins] = new Instructor() ;
                insobj[chosenins].InstructorName = "I1" ;
            }
            else {
                System.out.println("Wrong Input...");
                return;
            }
        }
        insmenu();
    }

    @Override
    //asking for student input
    public void askforid(int n) {

        System.out.println("""
                0 - S0
                1 - S1
                2 - S2""");
        System.out.print("Choose id: ");
        chosenstud = sc.nextInt() ;
        //creating student objects
        if (stud[chosenstud] == null) {
            if (chosenstud==0){
                stud[chosenstud] = new Student() ;
                stud[chosenstud].StudentName = "S0" ;
            }
            else if (chosenstud==1){
                stud[chosenstud] = new Student() ;
                stud[chosenstud].StudentName = "S1" ;
            }
            else if (chosenstud==2) {
                stud[chosenstud] = new Student() ;
                stud[chosenstud].StudentName = "S2" ;
            }
            else {
                System.out.println("Invalid Input...");
                return;
            }
        }
        studmenu() ;
    }

    //adding comments for instructor
    public void addComments(Instructor obj) {
        Scanner scn = new Scanner(System.in) ;
        String comm ;
        System.out.print("Enter comment: ");
        comm = scn.nextLine() ;
        cmnt[cmntcount] = new DiscussionForum() ;
        cmnt[cmntcount].comment = comm ;
        cmnt[cmntcount].name = obj.InstructorName ;
        Date curr = new Date() ;
        cmnt[cmntcount].time = curr.toString() ;
        cmntcount++ ;
    }

    //adding comments for student
    public void addComments(Student obj) {
        Scanner scn = new Scanner(System.in) ;
        String comm ;
        System.out.print("Enter comment: ");
        comm = scn.nextLine() ;
        cmnt[cmntcount] = new DiscussionForum() ;
        cmnt[cmntcount].comment = comm ;
        cmnt[cmntcount].name = obj.StudentName ;
        Date curr = new Date() ;
        cmnt[cmntcount].time = curr.toString() ;
        cmntcount++ ;
    }

    //viewing comments
    public void viewComments() {
        for (int i=0 ; i<cmntcount ; i++) {
            System.out.print(cmnt[i].comment + " - " + cmnt[i].name);
            System.out.println();
            System.out.println(cmnt[i].time);
        }
    }

    //viewing the lecture material
    public void viewLectureMaterials() {
        //all the lecture slides
        for (int i = 0; i < lcount; i++) {
            System.out.println("Title: " + lecobj[i].SlideTitle);
            for (int k = 0; k < lecobj[i].SlideNum; k++) {
                System.out.println("Slide " + (k + 1) + ": " + lecobj[i].SlideContent[k]);
            }
            System.out.println("Number of Slides: " + lecobj[i].SlideNum);
            System.out.println("Date of upload: " + lecobj[i].Slidedate);
            System.out.println("Uploaded by: " + lecobj[i].InsName);
            System.out.println();
        }
        System.out.println("------------------------------------------------------");

        //all lecture videos
        for (int j = 0; j < vcount; j++) {
            System.out.println("Title of video: " + vidobj[j].VideoTitle);
            System.out.println("Video file: " + vidobj[j].VideoFile);
            System.out.println("Date of upload: " + vidobj[j].Videodate);
            System.out.println("Uploaded by: " + vidobj[j].InsName);
            System.out.println();
        }
    }

    //viewing assessments (assignment + quiz)
    public void viewAssessments() {
        for (int i=0 ; i<assnum ; i++) {
            System.out.println("ID: " + i + " Assignment: " + assobj[i].problem + " Max Marks: " + assobj[i].maxmarks );
        }
        System.out.println("-------------------------------------");
        for (int j=0 ; j<quiznum ; j++) {
            System.out.println("ID: " + (assnum+j) + " Problem: " + quizobj[j].question) ;
        }
    }

    //instructor menu
    public void insmenu(){
        while(true) {
            System.out.println("Welcome " + insobj[chosenins].InstructorName);
            System.out.println("""
                INSTRUCTOR MENU
                       1. Add class material
                       2. Add assessments
                       3. View lecture materials
                       4. View assessments
                       5. Grade assessments
                       6. Close assessment
                       7. View comments
                       8. Add comments
                       9. Logout""");
            //asking from available options
            int op = sc.nextInt() ;

            //if the instructor wants to add class material
            if (op==1) {
                System.out.println("""
                1. Add Lecture Slide
                2. Add Lecture Video""");
                //asking for the kind of material (video/slides)
                int lect_op = sc.nextInt() ;

                //adding lecture slides
                if(lect_op==1) {
                    Scanner scn = new Scanner(System.in) ;
                    String slide_topic ;
                    System.out.print("Enter topic of slides: ");
                    slide_topic = scn.nextLine() ;
                    int slide_num ;
                    System.out.print("Enter number of slides: ");
                    slide_num = sc.nextInt() ;
                    String [] slide_content = new String[20] ;
                    for (int i=0 ; i <slide_num ; i++) {
                        System.out.print("Content of slide " + (i+1) + ": " );
                        slide_content[i] = scn.nextLine() ;
                    }

                    //creating lecture slide object
                    lecobj[lcount] = new LectureSlide() ;
                    lecobj[lcount].SlideTitle = slide_topic ;
                    lecobj[lcount].SlideNum = slide_num ;
                    lecobj[lcount].SlideContent = slide_content ;
                    Date SDate = new Date() ;
                    lecobj[lcount].Slidedate = SDate.toString() ;
                    lecobj[lcount].InsName = insobj[chosenins].InstructorName ;
                    lcount++ ;
                }

                //adding lecture videos
                else if(lect_op==2) {
                    Scanner scn = new Scanner(System.in) ;
                    String lecture_topic ;
                    System.out.print("Title of video: ");
                    lecture_topic = scn.nextLine() ;
                    String lecture_file ;
                    System.out.print("Video File: ");
                    lecture_file = sc.next() ;
                    //checking for file format
                    if (lecture_file.endsWith(".mp4")) {
                        vidobj[vcount] = new LectureVideo() ;
                        vidobj[vcount].VideoTitle = lecture_topic ;
                        vidobj[vcount].VideoFile = lecture_file ;
                        Date VDate = new Date() ;
                        vidobj[vcount].Videodate = VDate.toString() ;
                        vidobj[vcount].InsName = insobj[chosenins].InstructorName ;
                        vcount++ ;
                    }
                    else
                        System.out.println("Incorrect file format...");
                }
                else
                    System.out.println("Invalid Input..");
            }

            //If instructor wants to add assessments
            else if (op==2) {
                System.out.println("""
                1. Add Assignment
                2. Add Quiz""");
                //asking for the kind of assessment
                int assess_op = sc.nextInt() ;

                //adding assignments
                if (assess_op==1) {
                    Scanner scn = new Scanner(System.in) ;
                    System.out.print("Enter problem statement: ");
                    String problemo = scn.nextLine() ;
                    System.out.print("Enter maximum marks: ");
                    int marks = sc.nextInt() ;
                    assobj[assnum] = new Assignment() ;
                    assobj[assnum].assign(problemo,marks) ;
                    assnum++ ;
                }

                //adding quizzes
                else if (assess_op==2) {
                    Scanner scn = new Scanner(System.in) ;
                    System.out.print("Enter quiz question: ");
                    String question = scn.nextLine() ;
                    quizobj[quiznum] = new Quizzes() ;
                    quizobj[quiznum].assign(question);
                    quiznum++ ;
                }
                else
                    System.out.println("Invalid Input...");
            }
            //View Lecture Materials
            else if (op==3) {
                viewLectureMaterials();
                }

            //View Assessments
            else if (op==4) {
                viewAssessments();
                }

            //Grade assignments
            else if (op==5) {
                System.out.println("List of assessments: ");
                for (int i=0 ; i<assnum ; i++) {
                    System.out.println("ID: " + i + " Assignment: " + assobj[i].problem + " Max Marks: " + assobj[i].maxmarks );
                }
                System.out.println("-------------------------------------");
                for (int j=0 ; j<quiznum ; j++) {
                    System.out.println("ID: " + (assnum+j) + " Problem: " + quizobj[j].question) ;
                }
                System.out.print("Enter ID of assessment to view submissions: ");
                int ID = sc.nextInt();
                System.out.println("Choose ID from these ungraded submissions: ") ;

                //assignments
                if (ID<assnum) {
                    if (stud[0]!=null) {
                        if (stud[0].assignment_done[ID])
                            System.out.println(0 + " " + stud[0].StudentName) ;
                    }
                    if (stud[1]!=null) {
                        if (stud[1].assignment_done[ID])
                            System.out.println(1 + " " + stud[1].StudentName) ;
                    }
                    if (stud[2]!=null) {
                        if (stud[2].assignment_done[ID])
                            System.out.println(2 + " " + stud[2].StudentName) ;
                    }
                }
                //quizzes
                else if(ID<assnum+quiznum) {
                    if (stud[0]!=null) {
                        if (stud[0].quiz_done[ID - assnum])
                            System.out.println(0 + " " + stud[0].StudentName);
                    }
                    if (stud[1]!=null){
                        if (stud[1].quiz_done[ID - assnum])
                            System.out.println(1 + " " + stud[1].StudentName) ;
                    }
                    if (stud[2]!=null){
                        if (stud[2].quiz_done[ID - assnum])
                            System.out.println(2 + " " + stud[2].StudentName) ;
                    }
                }
                else
                    System.out.println("Wrong ID entered");

                int stud_id = sc.nextInt() ;
                //assignment
                if (ID<assnum && stud[stud_id].graded_ass_obj != null) {
                    System.out.print("Submission: " + stud[stud_id].graded_ass_obj[ID].file_name);
                }
                //quiz
                else if (ID>=assnum && ID<assnum+quiznum && stud[stud_id].graded_quiz_obj[ID] !=null)
                    System.out.println("Answer: " + stud[stud_id].graded_quiz_obj[ID].quiz_answers);
                else
                    System.out.println("Wrong ID entered...");

                System.out.print("\nMax Marks: ");
                if (ID<assnum) {
                    System.out.println(assobj[ID].maxmarks);
                    System.out.print("Marks Scored: ");
                    stud[stud_id].graded_ass_obj[ID].assignment_marks = sc.nextInt();
                    stud[stud_id].graded_ass_obj[ID].InsName = insobj[chosenins].InstructorName ;
                    stud[stud_id].graded_ass_obj[ID].graded = true ;
                }
                else{
                    System.out.println(assobj[ID-assnum].maxmarks);
                    System.out.print("Marks scored: ");
                    int marks = sc.nextInt() ;
                    if (marks==0 || marks==1)
                        stud[stud_id].graded_quiz_obj[ID-assnum].quiz_marks = marks ;
                    else
                        stud[stud_id].graded_quiz_obj[ID-assnum].quiz_marks = 0 ;
                    stud[stud_id].graded_quiz_obj[ID-assnum].quizName = insobj[chosenins].InstructorName ;
                    stud[stud_id].graded_quiz_obj[ID-assnum].graded = true ;
                }
            }

            //CLose an assessment
            else if (op==6) {
                System.out.println("List of Open Assessments: ");
                int f = -1;
                //printing assignment
                for (int i=0 ; i<assnum ; i++) {
                    if (assobj[i].asscheckopen){
                        System.out.println("ID: " + i + " Assignment: " + assobj[i].problem + " Max Marks: " + assobj[i].maxmarks );
                        f = 1 ;
                    }
                }
                System.out.println("-------------------------------------");
                //printing quizzes
                for (int j=0 ; j<quiznum ; j++) {
                    if (quizobj[j].quizcheckopen) {
                        System.out.println("ID: " + (assnum + j) + " Problem: " + quizobj[j].question);
                        f = 1;
                    }
                }
                if (f==-1) {
                    System.out.println("No open assessments left..");
                    break ;
                }
                System.out.print("Enter ID of assessment to close: ");
                int close = sc.nextInt() ;
                if (close<assnum)
                    assobj[close].asscheckopen = false ;
                else
                    quizobj[close-assnum].quizcheckopen = false ;
            }
            //View comments
            else if (op==7) {
                viewComments();
            }

            //Add comments
            else if (op==8) {
                addComments(insobj[chosenins]);
            }

            //Log out
            else if (op==9) {
                System.out.println("Logging out...");
                break ;
            }
            else
                System.out.println("Invalid Input");
        }
    }

    //student menu
    public void studmenu() {
        while(true) {
            System.out.println("Welcome " + stud[chosenstud].StudentName);
            System.out.println("""
                STUDENT MENU
                       1. View lecture materials
                       2. View assessments
                       3. Submit assessments
                       4. View Grades
                       5. View comments
                       6. Add comments
                       7. Logout""");
            //asking from available options
            int op = sc.nextInt() ;

            //View Lecture Materials
            if (op==1) {
              viewLectureMaterials();
            }


            //View Assessments
            else if (op==2) {
               viewAssessments();
                }

            //Submit Assessments
            else if (op==3) {
                System.out.println("Pending Assignments");
                int f=-1 ;
                //assignments
                for (int i=0 ; i<assnum ; i++) {
                    if (!stud[chosenstud].assignment_done[i] && assobj[i].asscheckopen) {
                        f=1 ;
                        System.out.println("ID: " + i + " Assignment: " + assobj[i].problem + " Max marks: " + assobj[i].maxmarks);
                        }
                    }
                System.out.println("-------------------------------------");
                //quizzes
                for (int j = 0; j < quiznum; j++) {
                    if (!stud[chosenstud].quiz_done[j] && quizobj[j].quizcheckopen) {
                        f=1 ;
                        System.out.println("ID: " + (assnum + j) + " Problem: " + quizobj[j].question);
                       }
                    }
                if (f==-1) {
                    System.out.println("No pending assessments... ");
                    continue;
                }
                System.out.print("Enter ID of Assignment: ");
                int ID = sc.nextInt() ;
                //assignment
                if (ID < assnum) {
                    System.out.print("Enter filename of assignment: ");
                    String filename = sc.next() ;
                    //checking file format
                    if (filename.endsWith(".zip")) {
                        stud[chosenstud].assignment_done[ID] = true ;
                        stud[chosenstud].graded_ass_obj[ID] = new submitted_assignments() ;
                        stud[chosenstud].graded_ass_obj[ID].file_name = filename ;
                    }

                    else
                        System.out.println("Invalid Format...");

                }
                //quizzes
                else if (ID<assnum+quiznum) {
                    System.out.print(quizobj[ID - assnum].question + ": ");
                    String answer = sc.next() ;
                    stud[chosenstud].quiz_done[ID - assnum] = true ;
                    stud[chosenstud].graded_quiz_obj[ID-assnum] = new submitted_quizzes() ;
                    stud[chosenstud].graded_quiz_obj[ID-assnum].quiz_answers = answer ;
                }
                else
                    System.out.println("Incorrect ID entered...");
            }

            //View Grades
            else if (op==4) {
                System.out.println("Graded Submissions: ");
                //Assignments
                for (int i = 0; i<assnum ; i++) {
                    if (stud[chosenstud].graded_ass_obj[i] != null) {
                        if (stud[chosenstud].assignment_done[i] && stud[chosenstud].graded_ass_obj[i].graded) {
                            System.out.println("Submission: " + stud[chosenstud].graded_ass_obj[i].file_name);
                            System.out.println("Marks Scored: " + stud[chosenstud].graded_ass_obj[i].assignment_marks);
                            System.out.println("Graded by: " + stud[chosenstud].graded_ass_obj[i].InsName);
                        }
                    }
                }
                System.out.println();
                //Quizzes
                for (int i = 0; i<quiznum ; i++) {
                    if (stud[chosenstud].graded_quiz_obj[i] != null) {
                        if (stud[chosenstud].quiz_done[i] && stud[chosenstud].graded_quiz_obj[i].graded) {
                            System.out.println("Answer: " + stud[chosenstud].graded_quiz_obj[i].quizName);
                            System.out.println("Marks Scored: " + stud[chosenstud].graded_quiz_obj[i].quiz_marks);
                            System.out.println("Graded by: " + stud[chosenstud].graded_quiz_obj[i].quizName);
                        }
                    }
                }
                System.out.println("----------------------------------");
                System.out.println("Ungraded Submissions: ");
                //Assignments
                for (int i = 0; i<assnum ; i++ ) {
                    if (stud[chosenstud].graded_ass_obj[i] != null){
                        if (stud[chosenstud].assignment_done[i] && !stud[chosenstud].graded_ass_obj[i].graded){
                            System.out.print("Submission: " + stud[chosenstud].graded_ass_obj[i].file_name);
                        }
                    }
                }
                System.out.println();
                //Quizzes
                for (int i = 0; i<quiznum ; i++) {
                    if (stud[chosenstud].graded_quiz_obj != null) {
                        if (stud[chosenstud].quiz_done[i] && !stud[chosenstud].graded_quiz_obj[i].graded) {
                            System.out.println("Submission: " + stud[chosenstud].graded_quiz_obj[i].quiz_answers);
                        }
                    }
                }
            }

            //View Comments
            else if (op==5) {
               viewComments();
            }

            //Add Comments
            else if (op==6) {
                addComments(stud[chosenstud]);
            }

            //Logout
            else if (op==7) {
                System.out.println("Logging out...");
                break ;
            }

            else
                System.out.println("Invalid input...");
        }
    }

}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Backpack obj = new Backpack() ;
        int choice ;

        while(true) {
            System.out.println("""
                Welcome to Backpack
                1. Enter as instructor
                2. Enter as student
                3. Exit""");
            choice = sc.nextInt() ;
            //Enter as instructor
            if (choice==1) {
                obj.askforid();
            }

            //Enter as Student
            else if (choice==2) {
                obj.askforid(1);
            }

            //Exit
            else if (choice==3) {
                System.out.println("Exiting...");
                break ;
            }
            else {
                System.out.println("Invalid Input...");
            }
        }
    }
}



