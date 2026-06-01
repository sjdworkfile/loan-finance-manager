# Loan & Finance Manager

یک اپلیکیشن اندرویید برای مدیریت جامع وام‌ها، هزینه‌ها و دارایی‌های شخصی

## ✨ ویژگی‌ها

### 📊 مدیریت وام‌ها
- ثبت وام‌های جدید با مشخصات کامل
- مشخص کردن مبلغ، قسط و تاریخ پایان
- افزودن نام بانک و شرح وام
- علامت گذاری وام‌های تمام شده

### 💳 مدیریت قسط‌ها
- ثبت خودکار قسط‌های ماهانه
- تاریخ و مبلغ هر قسط
- علامت گذاری قسط‌های پرداخت شده
- تاریخچه پرداخت‌ها

### 🔔 یادآوری‌ها و اعلان‌ها
- تنظیم یادآوری برای هر قسط
- اعلان‌های محلی در روز مقررشده
- مدیریت آلارم‌ها

### 📈 داشبورد
- نمای کلی وضعیت مالی
- کل وام‌های فعال
- قسط‌های ماهانه
- بقیه مانده وام‌ها

### 📋 گزارش‌ها
- آمار کل وام‌های گرفته شده
- نمودارهای درآمد و هزینه
- خلاصه قسط‌های پرداخت شده
- جزئیات هر وام

### 💰 هزینه‌های ثابت
- ثبت هزینه‌های ماهانه (شهریه، اشتراک‌ها)
- محاسبه خودکار درآمد باقی مانده
- مدیریت فئات هزینه

### 🪙 مدیریت دارایی‌ها
- ثبت مقدار طلا، نقره، دلار، سکه
- بروزرسانی نرخ‌های روز
- محاسبه ارزش کل دارایی‌ها
- نمودار توزیع دارایی‌ها

### 🌐 آفلاین اول
- کار کامل بدون اینترنت
- ذخیره‌سازی محلی تمام داده‌ها
- هماهنگی‌سازی خودکار (آینده)

### 🎨 شخصی‌سازی
- انتخاب تم‌های مختلف
- تغییر رنگ‌های اصلی
- قلم‌های مختلف
- تنظیمات ظاهری

## 🏗️ معماری

```
app/
├── data/
│   ├── db/           # Room Database
│   ├── repository/   # Data Layer
│   └── models/       # Entity Models
├── domain/
│   ├── usecase/      # Business Logic
│   └── models/       # Domain Models
├── presentation/
│   ├── ui/           # Compose Screens
│   ├── viewmodel/    # ViewModels
│   └── navigation/   # Navigation Graph
├── utils/            # Utilities
└── di/               # Dependency Injection
```

## 🛠️ تکنولوژی

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Database:** Room (SQLite)
- **Architecture:** MVVM + Clean Architecture
- **Dependency Injection:** Hilt
- **Notifications:** WorkManager
- **Navigation:** Compose Navigation
- **State Management:** ViewModel + StateFlow

## 📱 نیازمندی‌ها

- Android 8.0+ (API Level 26)
- Kotlin 1.8+
- Gradle 8.0+

## 🚀 شروع

کلون کنید و پروژه را در Android Studio باز کنید:

```bash
git clone https://github.com/sjdworkfile/loan-finance-manager.git
cd loan-finance-manager
```

## 📄 لایسنس

MIT License

## 📧 ارتباط

برای سوالات و پیشنهادات: [Issues](https://github.com/sjdworkfile/loan-finance-manager/issues)
