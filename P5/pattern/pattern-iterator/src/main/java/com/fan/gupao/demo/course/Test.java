package com.fan.gupao.demo.course;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Test {


    public static void main(String[] args) {

        Course course = new Course("Java架构");
        Course javaBase = new Course("Java基础");
        Course design = new Course("设计模式");
        Course ai = new Course("人工智能");

        ICourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(course);
        courseAggregate.add(javaBase);
        courseAggregate.add(design);
        courseAggregate.add(ai);


        System.out.println("课程列表");
        printCourse(courseAggregate);

        courseAggregate.remove(ai);


        System.out.println("删除操作之后的课程列表");
        printCourse(courseAggregate);
    }

    private static void printCourse(ICourseAggregate courseAggregate) {
        Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()){
            Course course = iterator.next();
            System.out.println("《"+course.getName()+"》");
        }
    }
}
