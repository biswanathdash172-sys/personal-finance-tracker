# 💰 Personal Finance Tracker

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-003545?style=for-the-badge&logo=h2&logoColor=white)

A simple web app to track your daily income and expenses. You can add transactions, pick a category, and see how much you're spending each month.

> 🛠️ Built as a learning project using Java + Spring Boot.

---

## ✨ What It Does

- ➕ Add income or expense transactions
- 🗂️ Assign categories like Food, Transport, Shopping, etc.
- 📋 View a list of all your transactions
- 📅 See a monthly summary of how much you earned vs spent

---

## 🛠️ Tech Stack

| What        | Tool Used                      |
|-------------|--------------------------------|
| Language    | Java                           |
| Framework   | Spring Boot                    |
| Database    | H2 (built-in, no setup needed) |
| Frontend    | Thymeleaf (HTML templates)     |
| Build Tool  | Maven                          |

> **Why H2?** It's a database that runs inside the app — no installation needed. Perfect for learning and small projects.

---

## 🚀 How to Run

### What you need installed first
- [Java 17](https://adoptium.net/) (or higher)
- [Maven](https://maven.apache.org/install.html)
- An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recommended)

### Steps

1. **Download the project**
   ```bash
   git clone https://github.com/your-username/personal-finance-tracker.git
   cd personal-finance-tracker
   ```

2. **Run the app**
   ```bash
   mvn spring-boot:run
   ```

3. **Open your browser and go to:**
   ```
   http://localhost:8080
   ```

That's it! 🎉 No database setup, no extra config needed.

---

## 📂 Project Structure

```
personal-finance-tracker/
├── src/
│   ├── main/
│   │   ├── java/com/yourname/financetracker/
│   │   │   ├── controller/     # Handles web requests
│   │   │   ├── service/        # App logic lives here
│   │   │   ├── repository/     # Talks to the database
│   │   │   └── model/          # Transaction & Category classes
│   │   └── resources/
│   │       ├── templates/      # HTML pages (Thymeleaf)
│   │       └── application.properties
│   └── test/                   # Tests
└── pom.xml
```

---

## 📸 Screenshots

<img width="1754" height="797" alt="Screenshot 2026-03-04 014139" src="https://github.com/user-attachments/assets/a9f9b26c-0a83-4190-b821-1062484eafda" />
<img width="668" height="818" alt="Screenshot 2026-03-04 014156" src="https://github.com/user-attachments/assets/8b306aec-5e12-4f29-81ab-8419dfbb7706" />



---

## 🗺️ What I Want to Add Next

- [ ] Edit and delete transactions
- [ ] Filter by category or month
- [ ] Simple charts to visualize spending
- [ ] Export transactions as a CSV file

---

## 📄 License

This project is open source under the [MIT License](LICENSE).
