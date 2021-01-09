package com.example.currencyexchange.di;

import com.example.currencyexchange.CurrencyExchangeApp;
import com.example.currencyexchange.di.modules.ActivityModule;
import com.example.currencyexchange.di.modules.ContractsModule;
import com.example.currencyexchange.di.modules.DataModule;
import com.example.currencyexchange.di.modules.FragmentsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        DataModule.class,
        ActivityModule.class,
        FragmentsModule.class,
        ContractsModule.class,

})
public interface AppComponent {
    void inject(CurrencyExchangeApp currencyExchangeApp);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder applicationBind(CurrencyExchangeApp currencyExchangeApp);

        AppComponent build();
    }

}
