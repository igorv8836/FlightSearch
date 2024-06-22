package com.example.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.database.dao.OfferDao
import com.example.database.dao.TicketDao
import com.example.database.dao.TicketsOfferDao
import com.example.database.entities.OfferEntity
import com.example.database.entities.TicketEntity
import com.example.database.entities.TicketsOfferEntity
import com.example.database.entities.ticketEntities.ArrivalEntity
import com.example.database.entities.ticketEntities.DepartureEntity
import com.example.database.entities.ticketEntities.HandLuggageEntity
import com.example.database.entities.ticketEntities.LuggageEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject


@RunWith(AndroidJUnit4::class)
class DatabaseTest : KoinTest {
    private val ticketDao: TicketDao by inject()
    private val offerDao: OfferDao by inject()
    private val ticketsOfferDao: TicketsOfferDao by inject()

    @Before
    fun setup() {
        stopKoin()
        val context = ApplicationProvider.getApplicationContext<Context>()
        startKoin {
            androidContext(context)
            modules(testDatabaseModule)
        }
    }

    @After
    fun tearDown() {
        runBlocking {
            ticketDao.deleteAll()
            offerDao.deleteAll()
            ticketsOfferDao.deleteAll()
        }
        stopKoin()
    }

    @Test
    fun testDatabaseOperations() = runBlocking {

        val offer = OfferEntity(
            id = 0,
            price = 100,
            title = "test",
            town = "fda"
        )
        offerDao.insert(offer)

        val ticketsOffer = TicketsOfferEntity(
            id = 0,
            price = 100,
            timeRange = listOf("test", "test2"),
            title = "test"
        )
        ticketsOfferDao.insert(ticketsOffer)

        val ticket = TicketEntity(
            id = 0,
            badge = "test",
            price = 100,
            providerName = "test",
            company = "test",
            departure = DepartureEntity(
                departureId = 0,
                date = "test",
                town = "test",
                airport = "test"
            ),
            arrival = ArrivalEntity(
                arrivalId = 0,
                date = "test",
                town = "test",
                airport = "test"
            ),
            hasTransfer = true,
            hasVisaTransfer = true,
            luggage = LuggageEntity(
                luggageId = 0,
                price = 100,
                hasLuggage = true
            ),
            handLuggage = HandLuggageEntity(
                handLuggageId = 0,
                hasHandLuggage = true,
                size = "test"
            ),
            isReturnable = true,
            isExchangable = true
        )
        ticketDao.insert(ticket)


        val allOffers = offerDao.getAll()
        assert(allOffers.isNotEmpty())

        val allTicketsOffers = ticketsOfferDao.getAll()
        assert(allTicketsOffers.isNotEmpty())

        val allTickets = ticketDao.getAll()
        assert(allTickets.isNotEmpty())
    }
}

private val testDatabaseModule = module {
    single {
        Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
    }
    single { get<AppDatabase>().ticketDao() }
    single { get<AppDatabase>().offerDao() }
    single { get<AppDatabase>().ticketsOfferDao() }
}