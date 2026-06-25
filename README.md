# ✅ Todo App

A beautiful and feature-rich todo application built with Android, Kotlin, and Jetpack Compose.

## ✨ Features
- Create, edit, delete tasks
- Mark tasks as complete
- Set priorities (High, Medium, Low)
- Set due dates and reminders
- Categories/Folders
- Search and filter
- Drag to reorder
- Statistics dashboard
- Dark mode
- Local notifications

## 🛠️ Tech Stack
- **Language:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Architecture:** MVVM + Clean Architecture
- **Database:** Room
- **DI:** Hilt
- **Notifications:** WorkManager + AlarmManager
- **Min SDK:** 26
- **Target SDK:** 34

## 📸 Screenshots
<div align="center">
<img src="screenshots/home.png" width="250">
<img src="screenshots/add-task.png" width="250">
<img src="screenshots/categories.png" width="250">
</div>

## 🏗️ Architecture
```
app/
├── data/
│   ├── local/
│   │   ├── TodoDatabase.kt
│   │   ├── TodoDao.kt
│   │   └── CategoryDao.kt
│   └── repository/
│       ├── TodoRepositoryImpl.kt
│       └── CategoryRepositoryImpl.kt
├── domain/
│   ├── model/
│   │   ├── Todo.kt
│   │   └── Category.kt
│   ├── repository/
│   │   ├── TodoRepository.kt
│   │   └── CategoryRepository.kt
│   └── usecase/
│       ├── GetTodosUseCase.kt
│       ├── AddTodoUseCase.kt
│       └── DeleteTodoUseCase.kt
├── ui/
│   ├── screens/
│   │   ├── home/
│   │   ├── addedit/
│   │   ├── categories/
│   │   └── statistics/
│   ├── components/
│   │   ├── TodoItem.kt
│   │   ├── PriorityChip.kt
│   │   └── DatePicker.kt
│   └── theme/
├── worker/
│   └── ReminderWorker.kt
└── di/
    └── AppModule.kt
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog+
- JDK 17

### Installation
```bash
# Clone
git clone https://github.com/nelwaderushikesh27/todo-app.git

# Open in Android Studio
# Build and run
```

## 📦 Key Dependencies
```kotlin
// Room
implementation "androidx.room:room-runtime:2.6.1"
implementation "androidx.room:room-ktx:2.6.1"
kapt "androidx.room:room-compiler:2.6.1"

// Compose
implementation "androidx.compose.material3:material3:1.2.0"
implementation "androidx.compose.ui:ui:1.6.0"

// Hilt
implementation "com.google.dagger:hilt-android:2.50"
kapt "com.google.dagger:hilt-compiler:2.50"

// WorkManager
implementation "androidx.work:work-runtime-ktx:2.9.0"

// Navigation
implementation "androidx.navigation:navigation-compose:2.7.6"
```

## 🎯 App Features

### Task Management
- Quick add with FAB
- Inline editing
- Swipe to delete
- Long press for options

### Smart Lists
- Today's tasks
- Upcoming tasks
- Completed tasks
- Custom categories

### Statistics
- Tasks completed per day/week
- Productivity trends
- Category breakdown

## 🤝 Contributing
Contributions welcome! See [CONTRIBUTING.md](CONTRIBUTING.md).

## 📄 License
MIT License

---

Made with ❤️ by [Your Name]
