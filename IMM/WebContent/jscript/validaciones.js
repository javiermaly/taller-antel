/*
	Controla el ingreso de fechas con el formato dd/mm/yyyy, ddmmyyyy, ddmmyy
*/
	function datevalid(fecha) {
        var sfecha = fecha.value;
        var dia = new Number();
        var mes = new Number();
        var ano = new Number();
        var vec = sfecha.split('/');

        if (vec.length == 3) { // si ingreso las barras
          dia = parseInt(vec[0]);
    		if (vec[1].substr(0,1)=='0') {
    			vec[1] = vec[1].substr(1,1);
   			}
          mes = parseInt(vec[1]);
          ano = parseInt(vec[2]);
        }
        else {
            var lF = sfecha.length;
            var sR = String();
            var lR = new Number();
            if ( (sfecha.indexOf('/') == -1) && (lF==6 || lF==8) ) {
                if (lF==6) {
                  ano = parseInt(sfecha.substr(sfecha.length - 2));
                }
                else {
                  ano = parseInt(sfecha.substr(sfecha.length - 4));
                }

                sdia = sfecha.substr(0, 2);
                if (sdia.substr(0,1) == '0') {
                  dia = parseInt(sdia.substr(1,1));
                }
                else {
                  dia = parseInt(sdia);
                }

                smes = sfecha.substr(2, 2);
                if (smes.substr(0,1) == '0') {
                  mes = parseInt(smes.substr(1,1));
                }
                else {
                  mes = parseInt(smes);
                }
            }
        }

        if (ano < 100) {
          if (ano < 30) {
            ano += 2000;
          }
          else {
            ano += 1900;
          }
        }
		
		if (dia > 31){
			fecha.value = "";
			return false;
		}
		
		if (mes > 12){
			fecha.value= "";
			return false;
		}
		
		if ((ano > 0) && (mes > 0) && (ano > 0)){
	        ddia = new Date(ano, mes-1, dia, 0, 0);
	        sdia = ('00' + ddia.getDate() )
	        sdia = sdia.substr(sdia.length - 2, 2);
	        smes = ('00' + (ddia.getMonth()+1) )
	        smes = smes.substr(smes.length - 2, 2);
	        fecha.value = sdia + '/' + smes + '/' + ddia.getFullYear();
	        return false;
	    }else {
	    	fecha.value = "";
	    	return false;
	    }      
        return false;
}

function notimevalid(hora) {
        hora.value = '11:32:31';
        return false;
}

function timevalid(par_time) {
        var stime = par_time.value;
        var hora = new Number();
        var minuto = new Number();
        var segundo = new Number();
        var vec = stime.split(':');

        if (vec.length == 3) {
          hora = parseInt(vec[0]);
          minuto = parseInt(vec[1]);
          segundo = parseInt(vec[2]);
        }
        else {
          if (vec.length == 2) {
            hora = parseInt(vec[0]);
            minuto = parseInt(vec[1]);
            segundo = 0;
          }
          else {
            var lF = stime.length;
            var sR = String();
            var lR = new Number();
            if ( (stime.indexOf(':') == -1) && (lF == 2 || lF==4 || lF==6) ) {

                shor = stime.substr(0, 2);
                if (shor.substr(0,1) == '0') {
                  hora = parseInt(shor.substr(1,1));
                }
                else {
                  hora = parseInt(shor);
                }

                if (lF==2) {
                  minuto = 0;
                }
                else {
                  smin = stime.substr(2, 2);
                  if (smin.substr(0,1) == '0') {
                    minuto = parseInt(smin.substr(1,1));
                  }
                  else {
                    minuto = parseInt(smin);
                  }
                }

                if (lF<=4) {
                  segundo = 0;
                }
                else {
                  sseg = stime.substr(4, 2);
                  if (sseg.substr(0,1) == '0') {
                    segundo = parseInt(sseg.substr(1,1));
                  }
                  else {
                    segundo = parseInt(sseg);
                  }
                }
            }
          }
        }

        shora = ('00' + hora);
        shora = shora.substr(shora.length - 2, 2);
        sminuto = ('00' + minuto )
        sminuto = sminuto.substr(sminuto.length - 2, 2);
        ssegundo = ('00' + segundo )
        ssegundo = ssegundo.substr(ssegundo.length - 2, 2);

        par_time.value = shora + ':' + sminuto + ':' + ssegundo;
        par_time.value = shora + ':' + sminuto + ':' + ssegundo;
        return false;
}

function datevalid_interno(fecha) {
        var sfecha = fecha;
        var dia = new Number();
        var mes = new Number();
        var ano = new Number();
        var vec = sfecha.split('/');

        if (vec.length == 3) {
          dia = parseInt(vec[0]);
    if (vec[1].substr(0,1)=='0') {
    vec[1] = vec[1].substr(1,1);
    }
          mes = parseInt(vec[1]);
          ano = parseInt(vec[2]);
        }
        else {
            var lF = sfecha.length;
            var sR = String();
            var lR = new Number();
            if ( (sfecha.indexOf('/') == -1) && (lF==6 || lF==8) ) {
                if (lF==6) {
                  ano = parseInt(sfecha.substr(sfecha.length - 2));
                }
                else {
                  ano = parseInt(sfecha.substr(sfecha.length - 4));
                }

                sdia = sfecha.substr(0, 2);
                if (sdia.substr(0,1) == '0') {
                  dia = parseInt(sdia.substr(1,1));
                }
                else {
                  dia = parseInt(sdia);
                }

                smes = sfecha.substr(2, 2);
                if (smes.substr(0,1) == '0') {
                  mes = parseInt(smes.substr(1,1));
                }
                else {
                  mes = parseInt(smes);
                }
            }
        }

        if (ano < 100) {
          if (ano < 30) {
            ano += 2000;
          }
          else {
            ano += 1900;
          }
        }

        ddia = new Date(ano, mes-1, dia, 0, 0);
        sdia = ('00' + ddia.getDate() )
        sdia = sdia.substr(sdia.length - 2, 2);
        smes = ('00' + (ddia.getMonth()+1) )
        smes = smes.substr(smes.length - 2, 2);
        fecha.value = sdia + '/' + smes + '/' + ddia.getFullYear();
        return fecha.value;
}

function timevalid_interno(par_time) {
        var stime = par_time;
        var hora = new Number();
        var minuto = new Number();
        var segundo = new Number();
        var vec = stime.split(':');

        if (vec.length == 3) {
          hora = parseInt(vec[0]);
          minuto = parseInt(vec[1]);
          segundo = parseInt(vec[2]);
        }
        else {
          if (vec.length == 2) {
            hora = parseInt(vec[0]);
            minuto = parseInt(vec[1]);
            segundo = 0;
          }
          else {
            var lF = stime.length;
            var sR = String();
            var lR = new Number();
            if ( (stime.indexOf(':') == -1) && (lF == 2 || lF==4 || lF==6) ) {

                shor = stime.substr(0, 2);
                if (shor.substr(0,1) == '0') {
                  hora = parseInt(shor.substr(1,1));
                }
                else {
                  hora = parseInt(shor);
                }

                if (lF==2) {
                  minuto = 0;
                }
                else {
                  smin = stime.substr(2, 2);
                  if (smin.substr(0,1) == '0') {
                    minuto = parseInt(smin.substr(1,1));
                  }
                  else {
                    minuto = parseInt(smin);
                  }
                }

                if (lF<=4) {
                  segundo = 0;
                }
                else {
                  sseg = stime.substr(4, 2);
                  if (sseg.substr(0,1) == '0') {
                    segundo = parseInt(sseg.substr(1,1));
                  }
                  else {
                    segundo = parseInt(sseg);
                  }
                }
            }
          }
        }

        shora = ('00' + hora);
        shora = shora.substr(shora.length - 2, 2);
        sminuto = ('00' + minuto )
        sminuto = sminuto.substr(sminuto.length - 2, 2);
        ssegundo = ('00' + segundo )
        ssegundo = ssegundo.substr(ssegundo.length - 2, 2);

        par_time = shora + ':' + sminuto + ':' + ssegundo;
        return par_time;
}

function datetimevalid(fechahora) {
        var sfecha = fechahora.value;
        var vec = sfecha.split(' ');

        fecha = datevalid_interno(vec[0]);
        hora = timevalid_interno(vec[1]);
        fechahora.value = fecha + ' ' + hora;
}