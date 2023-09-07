package com.example.todo;

import java.time.LocalDate;
public class Task {
    // Class definition

        // Fields (variables)
        private LocalDate madeDate;
        private LocalDate dueDate;
        private String name;

        // Constructor
        public Task(String name, LocalDate date ) {
            madeDate = LocalDate.now();
            this.name = name;
            dueDate = date;
        }

        // Methods
        public void doSomething() {
            System.out.println("Doing something!");
        }

        // Getter and Setter methods (optional)
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

}
