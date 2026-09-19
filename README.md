# Automation Testing Framework

[![Author](https://img.shields.io/badge/Author-Nivethitha%20Senthilkumar-blue.svg)](https://github.com/nivethithasenthilkumar)
[![Live Report Dashboard](https://img.shields.io/badge/Live%20Report%20Dashboard-View%20Execution-22c55e.svg?logo=googlechrome&logoColor=white)](https://nivethithasenthilkumar.github.io/Automation_testing/)
[![Repository](https://img.shields.io/badge/Repository-Automation__testing-green.svg)](https://github.com/nivethithasenthilkumar/Automation_testing)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-yellow.svg)](https://maven.apache.org/)

A robust, enterprise-grade test automation framework designed and developed by **Nivethitha Senthilkumar** using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. This framework implements the **Page Object Model (POM)** design pattern with thread-safe parallel test execution, modular keyword abstractions, comprehensive HTML/ExtentReports reporting, and CI/CD readiness.

🔗 **Live Test Execution Dashboard**: [https://nivethithasenthilkumar.github.io/Automation_testing/](https://nivethithasenthilkumar.github.io/Automation_testing/)

---

## 👤 Author & Maintainer

**Nivethitha Senthilkumar**  
- **GitHub Profile**: [@nivethithasenthilkumar](https://github.com/nivethithasenthilkumar)  
- **Portfolio**: [nivenk-portfolio.netlify.app](https://nivenk-portfolio.netlify.app)  
- **Repository**: [Automation_testing](https://github.com/nivethithasenthilkumar/Automation_testing)  
- **Live Test Dashboard**: [https://nivethithasenthilkumar.github.io/Automation_testing/](https://nivethithasenthilkumar.github.io/Automation_testing/)

---

## 🚀 Tech Stack

| Technology | Version / Tool | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 17 | Core programming language |
| **Automation Tool** | Selenium WebDriver 4.x | Browser automation and DOM interactions |
| **Test Runner** | TestNG | Test structuring, assertions, annotations, and parallel execution |
| **Build & Dependency Tool** | Apache Maven | Project lifecycle management, dependency resolution, and CI build execution |
| **Design Pattern** | Page Object Model (POM) | Clean separation between page elements/actions and test scripts |
| **Reporting** | ExtentReports 5 & Allure Reports | Detailed test execution dashboards, logs, and screenshots |
| **Data Management** | Apache POI & DataFaker | Excel spreadsheet-driven testing and dynamic fake data generation |
| **Version Control** | Git & GitHub | Source code management and CI/CD workflows |

---

## 🏛️ Architecture & Page Object Model (POM)

The framework is structured using the **Page Object Model (POM)** architecture to enhance maintenance, reusability, and readability:

```
Automation_testing/
├── .github/workflows/          # GitHub Actions CI/CD workflows
├── src/
│   ├── main/
│   │   ├── java/com/nivethithasenthilkumar/automation/
│   │   │   ├── annotations/    # Custom framework annotations (@FrameworkAnnotation)
│   │   │   ├── config/         # Owner-based configuration bindings
│   │   │   ├── constants/      # Global framework constants and path resolvers
│   │   │   ├── driver/         # Thread-safe WebDriver management (ThreadLocal, BrowserFactory)
│   │   │   ├── enums/          # Enumerations (Browser, Platform, AuthorType, CategoryType)
│   │   │   ├── exceptions/     # Custom runtime framework exceptions
│   │   │   ├── helpers/        # Utilities (Excel, Database, JSON, Properties, ScreenRecorder)
│   │   │   ├── keywords/       # WebUI keywords wrapper providing fluent Selenium actions
│   │   │   ├── mail/           # Automated email reporting services
│   │   │   ├── projects/       # Application page objects
│   │   │   │   └── saucedemo/  # SauceDemo POM pages
│   │   │   ├── reports/        # ExtentReports & Allure managers
│   │   │   └── utils/          # Logging (Log4j2), screenshot captures, data faker, etc.
│   │   └── resources/
│   └── test/
│       ├── java/com/nivethithasenthilkumar/automation/
│       │   ├── common/         # BaseTest (Driver setup/teardown, listener attachments)
│       │   ├── dataprovider/   # TestNG DataProviders
│       │   ├── listeners/      # TestListener, RetryAnalyzer, AnnotationTransformer
│       │   └── projects/       # Pages and Test Cases grouped by application
│       │       ├── cms/        # E-Commerce CMS pages and test cases
│       │       ├── crm/        # CRM system pages and test cases
│       │       └── saucedemo/  # SauceDemo sample automation test suite
│       └── resources/
│           ├── config/         # Application properties and configurations
│           ├── testdata/       # Excel and JSON data files
│           └── suites/         # TestNG XML execution suite definitions
├── pom.xml                     # Maven project descriptor
├── CHANGELOG.txt               # Version history
└── README.md                   # Framework documentation
```

### Key Design Highlights
1. **Thread-Safe Driver Management**: Uses `ThreadLocal<WebDriver>` within `DriverManager` to enable reliable parallel browser runs without race conditions.
2. **Abstracted WebUI Keywords**: `WebUI` encapsulates complex Selenium operations (explicit waits, element clicks, JavaScript scrolls, and highlighted elements) with automatic logging and screenshot hooks.
3. **Listener Architecture**: `TestListener` intercepts test execution events to capture full-page screenshots on failure, record video clips (when configured), and stream status updates into ExtentReports.

---

## ⚙️ Prerequisites & Setup

1. **Java Development Kit (JDK)**: JDK 17 or higher installed and configured in `JAVA_HOME`.
2. **Apache Maven**: Version 3.8+ installed and accessible via `PATH`.
3. **Web Browsers**: Google Chrome, Mozilla Firefox, or Microsoft Edge installed.

### Clone the Repository
```bash
git clone https://github.com/nivethithasenthilkumar/Automation_testing.git
cd Automation_testing
```

---

## 🏃 Running Tests

### 1. Run Default Test Suite via Maven
```bash
mvn clean test
```

### 2. Run a Specific TestNG Suite
You can execute specific suites from `src/test/resources/suites/` using the `-DsuiteXmlFile` parameter:
```bash
# Run SauceDemo Test Suite
mvn clean test -DsuiteXmlFile=src/test/resources/suites/SauceDemoSuite.xml

# Run CRM Suite
mvn clean test -DsuiteXmlFile=src/test/resources/suites/CRM/SignIn-simple.xml

# Run All Tests
mvn clean test -DsuiteXmlFile=src/test/resources/suites/SuiteAll.xml
```

### 3. Run with Custom Browser or Headless Mode
Override configurations on the command line via Maven properties:
```bash
# Run tests in Chrome Headless mode
mvn clean test -Dbrowser=chrome -Dheadless=true

# Run tests in Firefox
mvn clean test -Dbrowser=firefox
```

---

## 📊 Test Reports & Logs

After test execution, reports and artifacts are generated in the `exports/` and `target/` directories:

- **ExtentReports HTML**: Located at `exports/ExtentReports/ExtentReports.html`
- **Screenshots**: Automatically captured on test failure and stored in `exports/ExportData/Images/`
- **Execution Videos**: (If enabled) saved in `exports/ExportData/Videos/`
- **Allure Reports**:
  Generate and view the interactive Allure dashboard:
  ```bash
  mvn allure:serve
  ```

---

## 📄 License & Ownership
Created and maintained by **Nivethitha Senthilkumar**. All rights reserved.
