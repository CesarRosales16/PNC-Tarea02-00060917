package com.uca.capas.tarea2.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/informacion")
	public @ResponseBody String informacion() {
		return "Nombre: César Alejandro Rosales Cruz. Carné: 00060917. Carrera: Ingeniería Informática. Año: 4to.";
	}

	@RequestMapping("/fecha")
	public @ResponseBody String fecha(HttpServletRequest request) {
		int dia = Integer.parseInt(request.getParameter("dia"));
		int mes = Integer.parseInt(request.getParameter("mes"));
		int annio = Integer.parseInt(request.getParameter("annio"));

		try {
			LocalDate fecha = LocalDate.of(annio, mes, dia);
			String diaSemana = fecha.getDayOfWeek().toString().toUpperCase();

			switch (diaSemana) {
			case "MONDAY":
				diaSemana = "Lunes";
				break;
			case "TUESDAY":
				diaSemana = "Martes";
				break;
			case "WEDNESDAY":
				diaSemana = "Miercoles";
				break;
			case "THURSDAY":
				diaSemana = "Jueves";
				break;
			case "FRIDAY":
				diaSemana = "Viernes";
				break;
			case "SATURDAY":
				diaSemana = "Sabado";
				break;
			case "SUNDAY":
				diaSemana = "Domingo";
				break;
			default:
				diaSemana = "Invalido";
				break;
			}

			return "El día de la semana fue/es/será: " + diaSemana;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return "Ingrese una fecha válida";
	}
}