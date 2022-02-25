package com.wf3.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

public class GestionDate implements IDate {

	public boolean isPassed(Date d) {
		Calendar dateDuJour = Calendar.getInstance();
		Calendar dateTest = Calendar.getInstance();
		dateTest.setTime(d);
		if (dateTest.before(dateDuJour)) {
			return true;
		}
		return false;
	}

	public boolean isFuture(Date d) {
		Calendar dateDuJour = Calendar.getInstance();
		Calendar dateTest = Calendar.getInstance();
		dateTest.setTime(d);
		if (dateTest.after(dateDuJour)) {
			return true;
		}
		return false;
	}

	@Override
	public Date stringToDate(String Sdate) {
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sfd.parse(Sdate);
		} catch (ParseException e) {
			System.out.println(e);
			System.out.println("Attention, le format de la date " + Sdate + " n'est pas valide !");
		}
		return null;
	}

	public String dateToString(Date dDate) {
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(dDate);

		Date date1 = c.getTime();
		try {
			return sfd.format(date1);
		} catch (DateTimeException e) {
			System.out.println(e);
			System.out.println("Attention, le format de la date " + dDate + " n'est pas valide !");
		}
		return null;
	}

	@Override
	public int diffYears(Date debut, Date fin) {
		// créé deux formats de date
		Calendar dateDebut1 = Calendar.getInstance();
		Calendar dateFin2 = Calendar.getInstance();

		dateDebut1.setTime(debut);
		dateFin2.setTime(fin);
		int Years = 0;

		try {
			if (dateDebut1.after(dateFin2)) {
				throw new Exception();
			} else {
				Years = dateFin2.get(Calendar.YEAR) - dateDebut1.get(Calendar.YEAR);
				dateFin2.add(Calendar.YEAR, -Years);
				if (dateDebut1.after(dateFin2)) {
					Years = Years - 1;
				}
				return Years;
			}
		} catch (Exception exception) {
			System.out.println("La date de début ne peut être après la date de fin !");
		}
		return -1;
	}

	@Override
	public int diffDays(Date debut, Date fin) {

		// créé deux formats de date
		Calendar dateDebut1 = Calendar.getInstance();
		Calendar dateFin2 = Calendar.getInstance();

		dateDebut1.setTime(debut);
		dateFin2.setTime(fin);

		Date dateD1 = dateDebut1.getTime();
		Date dateD2 = dateFin2.getTime();

		try {
			if (dateD1.after(dateD2)) {
				throw new Exception();
			} else {

				// calcul la différence de d'années
				int Days = 0;

				Days = dateFin2.get(Calendar.DAY_OF_YEAR) - dateDebut1.get(Calendar.DAY_OF_YEAR);

				int Years = diffYears(dateD1, dateD2);

				return Years * 365 + Days;
			}
		} catch (Exception exception) {
			System.out.println("La date de début ne peut être après la date de fin !");
		}
		return -1;
	}

	@Override
	public int diffMonths(Date debut, Date fin) {
		// créé deux formats de date
		Calendar dateDebut1 = Calendar.getInstance();
		Calendar dateFin2 = Calendar.getInstance();

		dateDebut1.setTime(debut);
		dateFin2.setTime(fin);

		// calcul la différence de d'années

		int Months = Math.abs(dateDebut1.get(Calendar.MONTH) - dateFin2.get(Calendar.MONTH));
		int Years = this.diffYears(debut, fin);

		return Years * 12 + Months;
	}
}