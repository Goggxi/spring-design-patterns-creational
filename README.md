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
#### Studi Kasus
* Aplikasi kita membutuhkan data Social Media, namun kita tidak terlalu peduli dengan implementasi detail social media nya
* Factory Method bisa menentukan implementasi detail object social media sesuai dengan tipe yang kita berikan

#### interface social media

```java
    public interface SocialMedia {
        String getName();
    
        String getUrl();
    
        SocialMediaType getType();
    }
```

#### enum social media type

```java
    public enum SocialMediaType {
        INSTAGRAM, FACEBOOK, TWITTER
    }
```

#### class facebook social media

```java
    public class FacebookV2SocialMedia implements SocialMedia {
    
        @Getter
        private final String name = "FACEBOOK";
    
        @Getter
        private final String url = "https://web.facebook.com";
    
        @Getter
        private final SocialMediaType type = SocialMediaType.FACEBOOK;
    }
    
    // class instagramSocialMedia ...

    // class twitterSocialMedia ...
```

#### class factory method

![Factory Method](http://www.plantuml.com/plantuml/png/ZP31QeOm48JF_px5uaaf-00MYwTUMsXV8CID3SHTMLT4Ij-zLffIxQMtPFXcXbdePdDgovW08XjfS9xmMQLVlE4xV03uvEOvIqzC6CSfqKXiF-fVxdMLVt6FpflejZVTxdAhLt96tx_onJJoWBPDLDr_-I_EMkFmPlL3JWHWCS94mL32fQTfJk5mY-58nhR5GfWALB956PdMNvFBwapQAXSoZzv9uXvPZ02w_NbSzXC0)

```java
    @SpringBootApplication
    public class FactoryMethodApplication {
    
        @Bean
        @Scope("prototype")
        public SocialMedia socialMedia(SocialMediaType type) {
            if (type == SocialMediaType.FACEBOOK) {
                return new FacebookV2SocialMedia();
            } else if (type == SocialMediaType.INSTAGRAM) {
                return new InstagramSocialMedia();
            } else if (type == SocialMediaType.TWITTER) {
                return new TwitterSocialMedia();
            } else {
                throw new IllegalArgumentException("Unsupported Social media Type");
            }
        }
    }
```
#### class factory inheritance

![Factory Inheritance](https://www.plantuml.com/plantuml/png/fOxF2e904CRFpbFCKGby08FmrBKElS2oZYNidrX79A9tRmMDjQ4ktdPcllrzlxfd5NYm1g1pJA5Lcl0SV3DenYUy0BHHVR-iJewmitT3bXn_jZ9t6VsFdAmvAiq-F69RjbkQTI35D4zviHS5yoVfivKOpJSGl-9bULW88CJJQnn1UAI1E08upuI6MaRVek1LrSe8CaTZmiyB8DVWn9X9eRlU96fg_eUAvnMgZi_1cZS0)

```java
    @SpringBootApplication
    public class FactoryInheritanceApplication {
    
        @Bean
        @Scope("prototype")
        public SocialMedia socialMediaFacebook() {
            return new FacebookV2SocialMedia();
        }
    
        @Bean
        @Scope("prototype")
        public SocialMedia socialMediaInstagram() {
            return new InstagramSocialMedia();
        }
    
        @Bean
        @Scope("prototype")
        public SocialMedia socialMediaTwitter() {
            return new TwitterSocialMedia();    
        }
    }
```

### - Abstract Factory Pattern

* GOF : Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
* Menyediakan sebuah interface untuk membuat keluarga object yang saling berkaitan tanpa perlu menentukan class konkret nya
* Kadang disebut juga dengan pattern Kit

![Factory Inheritance](http://www.plantuml.com/plantuml/png/jPF1IWD138RFpLFas2Bq0If84V7atVCmcws3ipCocr94V7TdDoj4CeeijASc-VFz-JlqEB8hV1uYG4XCfNUUy3caBb_m0pu1V7JZk7IUmkc5CGnlaGPA_DqskWTNNfioRN9_Piv9cqZ7c4ZRwCIaATD9kXFne_ESotlrsjmisNmXnoJ5TdTR1xA_3AIe0nLDeyoHrpAIb2jyi7x-iFh9sU_lK5OR0za3cr-jpVKl4lskOC8fo5Is1Uh90L9cmZBJSu_Myt3GlmLi4btqbTiTKEfmeloV9Vx2Kd4iArAlK2f6uoeLUmN8dcH0n_fr_cj_0G00)



