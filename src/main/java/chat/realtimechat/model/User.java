package chat.realtimechat.model;


import jakarta.persistence.*;

@Entity
@Table (name="korisnici")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String user_password;

        protected User() {}

        public User(String username, String email, String user_password) {
            this.username = username;
            this.email = email;
            this.user_password = user_password;  // Lozinku enkodira service sloj
        }

        public Long getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setUser_password(String password) {
            this.user_password = password;
        }
}

