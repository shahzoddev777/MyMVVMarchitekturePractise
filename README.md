# Contacts App

Kotlin va Jetpack Compose yordamida yaratilayotgan oddiy Contacts
ilovasi. Loyiha MVVM arxitekturasini tushunish va Compose UI bilan mashq
qilish uchun ishlab chiqilmoqda.

## Maqsad

-   MVVM arxitekturasining vazifalarini tushunish
-   View, ViewModel va Model o'rtasidagi aloqani amalda ko'rish
-   Jetpack Compose komponentlari bilan ishlash
-   UI State o'zgarganda Compose qanday yangilanishini o'rganish

## Texnologiyalar

-   Kotlin
-   Jetpack Compose
-   Material 3
-   ViewModel
-   Compose `State` va `mutableStateOf`

> Hozircha loyiha ataylab sodda saqlanadi. Coroutine, Flow, Hilt, Clean
> Architecture va Room ishlatilmaydi.

## MVVM tuzilishi

``` text
View (Compose)
    |
    | Event: masalan, deleteContact(id)
    v
ViewModel
    |
    | UI State
    v
View (Compose) qayta chiziladi
```

### Model

`Contact` --- kontakt ma'lumotlarini ifodalaydi.

``` kotlin
data class Contact(
    val id: String,
    val name: String,
    val surname: String
)
```

### ViewModel

`ContactViewModel` kontaktlar ro'yxatini va unga tegishli amallarni
boshqaradi.

Asosiy vazifalar:

-   Kontaktlar ro'yxatini saqlash
-   Kontakt qo'shish
-   Kontaktni ID orqali o'chirish
-   Kontaktni tahrirlash

State uchun boshlang'ich yondashuv:

``` kotlin
private val _contacts =
    mutableStateOf<List<Contact>>(emptyList())

val contacts: State<List<Contact>> = _contacts
```

`_contacts` ViewModel ichida o'zgartiriladi. `contacts` esa UI tomonidan
o'qiladi.

### View

Compose ekrani ViewModel'dan State oladi va ma'lumotlarni ko'rsatadi.

``` kotlin
@Composable
fun ContactScreen(viewModel: ContactViewModel) {
    val contacts = viewModel.contacts.value

    // Kontaktlarni Compose UI orqali ko‘rsatish
}
```

## Kontakt amallari

### Qo'shish

``` kotlin
fun addContact(contact: Contact) {
    _contacts.value += contact
}
```

### O'chirish

``` kotlin
fun deleteContact(id: String) {
    _contacts.value = _contacts.value.filter {
        it.id != id
    }
}
```

`filter` berilgan ID ga teng bo'lmagan kontaktlarni qoldiradi.

### Tahrirlash

``` kotlin
fun editContact(contact: Contact) {
    _contacts.value = _contacts.value.map {
        if (it.id == contact.id) contact else it
    }
}
```

`map` ro'yxat elementlarini ko'rib chiqadi va mos ID topilsa, eski
kontakt o'rniga yangisini qo'yadi.

## Rejalashtirilgan ishlar

-   [x] `Contact` modelini yaratish
-   [x] ViewModel'da kontaktlar State'ini e'lon qilish
-   [x] Kontakt qo'shish, o'chirish va tahrirlash logikasini yozish
-   [ ] Compose orqali kontaktlar ro'yxatini chiqarish
-   [ ] Kontakt qo'shish ekranini yaratish
-   [ ] Kontaktni tahrirlash ekranini yaratish
-   [ ] Qidiruv funksiyasini qo'shish
-   [ ] UI va ViewModel o'rtasidagi State/Event oqimini mustahkamlash

## Eslatma

Bu o'quv loyihasi. Hozirgi bosqichda kontaktlar ViewModel xotirasida
saqlanadi. Ilova qayta ishga tushirilganda ma'lumotlar saqlanib
qolmaydi. Keyingi bosqichlarda zarurat bo'lsa, lokal saqlash qo'shilishi
mumkin.
