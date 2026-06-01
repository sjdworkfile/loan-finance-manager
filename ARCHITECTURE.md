# معماری پروژه

## نمای کلی

پروژه از معماری **MVVM** و **Clean Architecture** پیروی می‌کند.

```
app/
├── data/
│   ├── db/
│   │   ├── dao/              # Data Access Objects
│   │   ├── entity/           # Database Entities
│   │   ├── converter/        # Type Converters
│   │   └── LoanDatabase.kt   # Room Database
│   ├── repository/           # Data Layer Repositories
│   └── models/               # Data Models
├── domain/
│   ├── usecase/              # Business Logic
│   └── models/               # Domain Models
├── presentation/
│   ├── screens/              # Compose Screens
│   ├── viewmodel/            # ViewModels
│   ├── navigation/           # Navigation Graph
│   ├── components/           # Reusable Compose Components
│   ├── theme/                # Theme Configuration
│   └── utils/                # UI Utilities
├── utils/                    # General Utilities
├── di/                       # Dependency Injection
├── workers/                  # WorkManager Tasks
└── notifications/            # Notification Logic
```

## لایه‌های معماری

### Data Layer (داده)
- **Database**: Room SQLite
- **DAOs**: لیست‌های Entity های پایگاه داده
- **Entities**: نمایش جداول پایگاه داده
- **Repositories**: دسترسی یکپارچه به داده‌ها

### Domain Layer (منطق کسب‌وکار)
- **Use Cases**: منطق تجاری اصلی
- **Domain Models**: مدل‌های داده مستقل از پیاده‌سازی

### Presentation Layer (رابط کاربری)
- **Screens**: صفحات Jetpack Compose
- **ViewModels**: مدیریت وضعیت و منطق صفحه
- **Components**: اجزای قابل استفاده دوباره
- **Navigation**: راهبری میان صفحات

## فناوری‌های استفاده شده

### Android
- **Kotlin**: زبان برنامه‌نویسی
- **Jetpack Compose**: رابط کاربری
- **Room**: پایگاه داده محلی
- **WorkManager**: کارهای پس‌زمینی
- **Hilt**: تزریق وابستگی

### Architecture Patterns
- **MVVM**: Model-View-ViewModel
- **Repository Pattern**: انتزاع منبع داده
- **Use Case Pattern**: کپسول‌بندی منطق تجاری
- **Dependency Injection**: مدیریت وابستگی‌ها

## جریان داده

```
User Interaction
    ↓
ViewModel
    ↓
Use Case
    ↓
Repository
    ↓
Database / Local Storage
```

## حالت (State Management)

استفاده از **StateFlow** و **ViewModel** برای مدیریت حالت:

```kotlin
class LoanViewModel @Inject constructor(
    private val getLoanUseCase: GetLoanUseCase
) : ViewModel() {
    private val _loans = MutableStateFlow<List<Loan>>(emptyList())
    val loans: StateFlow<List<Loan>> = _loans.asStateFlow()
    
    init {
        viewModelScope.launch {
            getLoanUseCase().collect { _loans.value = it }
        }
    }
}
```

## Dependency Injection (Hilt)

استفاده از Hilt برای تزریق خودکار وابستگی‌ها:

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideLoanDao(database: LoanDatabase): LoanDao {
        return database.loanDao()
    }
}
```

## محیط انقطاع‌ناپذیر (Offline-First)

- تمام داده‌ها به‌طور محلی ذخیره می‌شوند
- برنامه بدون اتصال اینترنت کار می‌کند
- هماهنگی‌سازی خودکار در صورت دسترسی اینترنت

## توسعه‌پذیری

معماری به‌گونه‌ای طراحی شده که:
- اضافه کردن ویژگی‌های جدید آسان است
- تست‌نویسی سهل است
- کدگذاری بدون انجام‌رسانی (Decoupling) وجود دارد
- جایگزینی پیاده‌سازی‌ها ممکن است

## بهینه‌سازی عملکرد

- استفاده از Flow برای انتقال داده‌های سریع
- Lazy Loading برای لیست‌های بزرگ
- Caching الگو برای داده‌های زیاد درخواست شده
