import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements IProfessorService {
    ICourseService courseService;

    ProfessorService() {
        courseService = new CourseService();
    }

    @Override
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @Override
    public List<Class> getClasses() {
        List<Class> classes = new ArrayList<>();
        String fileName = FileUtility.getReadableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Class cls = (Class) ois.readObject();
                    classes.add(cls);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
    }

    @Override
    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<>();
        String fileName = FileUtility.getReadableFileName(PROF_FILE_NAME_First, PROF_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Professor prof = (Professor) ois.readObject();
                    professors.add(prof);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return professors;
    }

    @Override
    public void updateClass(Class cls) {
        String readableFileName = FileUtility.getReadableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Class cla = (Class) ois.readObject();
                    if (cla.getCourse().getCourseName().equalsIgnoreCase(cls.getCourse().getCourseName())
                            && cla.getCourse().getProfessorName().equalsIgnoreCase(cls.getCourse().getProfessorName())
                            && cla.getTimeRange() == cls.getTimeRange()
                            && cla.getDay().equalsIgnoreCase(cls.getDay())) {
                        cla.setCourse(cls.getCourse());
                        cla.setCapacity(cls.getCapacity());
                        cla.setDay(cls.getDay());
                        cla.setTimeRange(cls.getTimeRange());
                    }
                    oos.writeObject(cla);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    ois.close();
                    fis.close();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(Class cls) {

    }

    @Override
    public void addProfessor(Professor professor) {
        String readableFileName = FileUtility.getReadableFileName(PROF_FILE_NAME_First, PROF_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(PROF_FILE_NAME_First, PROF_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Professor p = (Professor) ois.readObject();
                    oos.writeObject(p);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.writeObject(professor);
                    ois.close();
                    fis.close();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                String fileName = FileUtility.getWritableFileName(PROF_FILE_NAME_First, PROF_FILE_NAME_Second);
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(professor);
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean isConflict(Class cls) {
        List<Class> classe = getClasses();
        for (int i = 0; i < classe.size(); i++) {
            if (classe.get(i).getCourse().getProfessorName().equalsIgnoreCase(cls.getCourse().getProfessorName())
                    && classe.get(i).getCourse().getCourseName().equalsIgnoreCase(cls.getCourse().getCourseName())
                    && classe.get(i).getDay() == cls.getDay()
                    && classe.get(i).getTimeRange() == cls.getTimeRange()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addClass(Class cls) {
        String readableFileName = FileUtility.getReadableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Class c = (Class) ois.readObject();
                    oos.writeObject(c);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.writeObject(cls);
                    ois.close();
                    fis.close();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                String fileName = FileUtility.getWritableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second);
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(cls);
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void printClasses() {
        String fileName = FileUtility.getReadableFileName(CLASS_FILE_NAME_First, CLASS_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Class cls = (Class) ois.readObject();
                    System.out.println("Course: " + cls.getCourse().getCourseName() + " , " + "Professor: " + cls.getCourse().getProfessorName() + " , " + "timeRange: " + cls.getTimeRange() + " , " + "capcity: " + cls.getCapacity());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
