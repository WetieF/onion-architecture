package com.example.onionarchitecture.domain.sollstunden.model;

import com.example.onionarchitecture.domain.exceptions.*;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import lombok.*;
import org.springframework.util.StringUtils;

import java.time.YearMonth;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
public class BeraterSollStunden {
    Long id;
    @NonNull String beratername;
    @NonNull YearMonth monat;
    @NonNull Integer arbeitstage;
    @NonNull Double taeglicheArbeitsstunden;
    Double urlaubstage;
    @NonNull Double sollstunden;
    Double schulungstage;
    Double krankheitstage;
    Double sonstiges;

    private static final double MAX_ARBEITSSTUNDE_PRO_TAG = 10.0d;

    public BeraterSollStunden(
            Long id,
            String beratername,
            YearMonth monat,
            Integer arbeitstage,
            Double taeglicheArbeitsstunden,
            Double urlaubstage,
            Double sollstunden,
            Double schulungstage,
            Double krankheitstage,
            Double sonstiges) {

        if (!StringUtils.hasText(beratername)) {
            throw new keinBeraternameAngabeException();
        }

        if (arbeitstage > monat.lengthOfMonth()) {
            throw new ZuVielArbeitsstageErfasstExistException();
        }

        if (taeglicheArbeitsstunden > MAX_ARBEITSSTUNDE_PRO_TAG) {
            throw new ZuvieleTaeglicheArbeitsstundenException();
        }

        urlaubstage = Objects.isNull(urlaubstage) ? 0.0 : urlaubstage;
        schulungstage = Objects.isNull(schulungstage) ? 0.0 : schulungstage;
        krankheitstage = Objects.isNull(krankheitstage) ? 0.0 : krankheitstage;
        sonstiges = Objects.isNull(sonstiges) ? 0.0 : sonstiges;

        if (arbeitstage < 0 || urlaubstage < 0 || schulungstage < 0
            || krankheitstage < 0 || sonstiges < 0) {
            throw new ArbeitstageOderAbwesenheitsstageKleinerNullException();
        }

        if( (urlaubstage + schulungstage + krankheitstage + sonstiges) > arbeitstage) {
            throw new MehrAbwesenheitstageAlsArbeitstagErfasstException();
        }

        if( sollstunden != (arbeitstage - (urlaubstage + schulungstage + krankheitstage + sonstiges))
           * taeglicheArbeitsstunden) {
            throw new SollstundenNichtValideException();
        }

        this.id = id;
        this.beratername = beratername;
        this.monat = monat;
        this.arbeitstage = arbeitstage;
        this.taeglicheArbeitsstunden = taeglicheArbeitsstunden;
        this.urlaubstage = urlaubstage;
        this.sollstunden = sollstunden;
        this.schulungstage = schulungstage;
        this.krankheitstage = krankheitstage;
        this.sonstiges = sonstiges;
    }

    public Sollstunden toSollstunden() {
        return Sollstunden.builder()
                .id(getId())
                .beratername(getBeratername())
                .monat(getMonat())
                .arbeitstage(getArbeitstage())
                .taeglicheArbeitsstunden(getTaeglicheArbeitsstunden())
                .urlaubstage(getUrlaubstage())
                .sollstunden(getSollstunden())
                .schulungstage(getSchulungstage())
                .krankheitstage(getKrankheitstage())
                .sonstiges(getSonstiges())
                .build();
    }
}
