package com.example.todo;

import java.time.LocalDate;
public class Task {
    // Class definition

        // Fields (variables)
        private LocalDate madeDate;
        private LocalDate dueDate;
        private String name;
        private Boolean isCompleted;

        // Constructor
        public Task(String name, LocalDate date ) {
            madeDate = LocalDate.now();
            this.name = name;
            dueDate = date;
        }

        public Task(String name){
            madeDate = LocalDate.now();
            this.name = name;
        }

        // Methods
        public void doSomething() {
            System.out.println("Doing something!");
        }

        // Getter and Setter methods

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getName() {
        return name;
    }

         public void setName(String name) {
        this.name = name;
    }

        public LocalDate getMadeDate() {
            return madeDate;
        }

        public void setMadeDate(LocalDate date) {
            madeDate = date;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public void setDueDate(LocalDate date) {
            dueDate = date;
        }

        // Main method (for testing)
        public static void main(String[] args) {

        }

    @Override
    public String toString() {
        return "Task{" +
                "madeDate=" + madeDate +
                ", isCompleted=" + isCompleted +
                ", dueDate=" + dueDate +
                ", name='" + name + '\'' +
                '}';
    }
}
