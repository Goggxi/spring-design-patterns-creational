## Spring Boot Design Pattern - _Creational_
* Creational Design Patterns adalah Design Patterns untuk membuat object.
* Creational Design Patterns membuat system menjadi lebih independen ketika membuat dan melakukan komposisi object
* Creational Design Patterns kadang menggunakan perawisan untuk membuat object
* Penggunaan Design Patterns tidak diharuskan hanya satu Pattern saja, kita bisa menggabungkan beberapa Design Patterns sekaligus jika memang dibutuhkan


### - Singleton Pattern
#### Studi Kasus
* Membuat sebuah counter sebagai statistic berapa banyak request yang sudah ditangani oleh aplikasi kita
* Membuat class Counter, dimana class counter ini akan menyimpan data jumlah counter, dan memiliki method untuk menaikkan data counter nya
* Membuat instance class Counter sebagai singleton object, karena data counter harus selalu sama, sehingga tidak memerlukan lebih dari satu instance object


#### Class Counter 
```java
    public class Counter {
        private Long value = 0L;

        public Long getValue() {
            return value;
        }

        public synchronized void increment() {
            value++;
        }
    }
```

#### Membuat Singleton

```java
    @SpringBootApplication
    public class SingletonApplication {
    
        @Bean
        public Counter counter() {
            return new Counter();
        }
        
    }
```

### - Prototype Pattern
#### Studi Kasus
* Membuat aplikasi kepegawaian, dimana terdapat data Employee
* Setiap Employee memiliki title / jabatan masing-masing, dan salary-nya selalu sama antar title
* Menggunakan prototype pattern untuk membuat object Employee, dimana kita bisa buat beberapa prototype sesuai dengan title nya

#### Class Employee
```java
    public class Employee {
    
        private String id;
    
        private String name;
    
        private Position position;
    
        private Long salary;
        
        // generate setter & getter
    
        // generate toString
    }
```

#### enum position
```java
    public enum Position {
        STAFF, MANAGER, VICE_PRESIDENT, C_LEVEL
    }
```

#### Membuat Singleton
```java
    @SpringBootApplication
    public class PrototypeApplication {
        
        @Bean
        @Scope("prototype")
        public Employee employeeStaff() {
            Employee employee = new Employee();
            employee.setPosition(Position.STAFF);
            employee.setSalary(10_000_000L);
            return employee;
        }
    
        @Bean
        @Scope("prototype")
        public Employee employeeManager() {
            Employee employee = new Employee();
            employee.setPosition(Position.MANAGER);
            employee.setSalary(20_000_000L);
            return employee;
        }
        
        // ...
    }
```

### - Builder Pattern
#### Studi Kasus
* Membuat aplikasi toko online, dimana memerlukan data Product
* Data product merupakan data yang kompleks, karena banyak sekali attribute yang terdapat di Product
* Membuat object Product menggunakan konstruktor atau menggunakan function satu per satu sangatlah melelahkan, oleh karena itu, lebih baik kita menggunakan builder pattern


#### class product
```java
    @Builder
    public class Product {
    
        private String id;
    
        private String name;
    
        private Long price;
    
        private Category category;
        
        // Constructor
    
        // Setter & Getter
    
        // toString
    }
```

#### enum category
```java
    public enum Category {
        GADGET, LAPTOP, SPEAKER
    }
```

#### membuat bulder pattern kombinasi dengan prototype pattern
```java
    @SpringBootApplication
    public class BuilderApplication {
    
        @Bean
        @Scope("prototype")
        public Product productGadget() {
            return Product.builder()
                    .category(Category.GADGET)
                    .build();
        }
    
        @Bean
        @Scope("prototype")
        public Product productSpeaker() {
            return Product.builder()
                    .category(Category.SPEAKER)
                    .build();
        }
    
    }
```
### - Factory Method Pattern
### - Abstract Factory Pattern
