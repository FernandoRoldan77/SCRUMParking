import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import './CSS/GRIDParking.css';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    height: 90,
    width: 140,
  },
  control: {
    padding: theme.spacing(2),
  },
}));

export default function SpacingGrid(props) {
  const [spacing] = React.useState(5);
  const classes = useStyles();

  return (
    <div className='containerGrid'>
      <Grid container className={classes.root}>
        <Grid item xs={12}>
          <Grid container justify="center" spacing={spacing}>
            {props.lugares.map((lugar,index) => (
              <Grid key={index} item>
                <Paper className={classes.paper}>
                  <button className="btn btn-lg btn-outline-dark item-grid" value={index} onClick={props.modify} >{ lugar.get("patente")}</button>
                </Paper>
              </Grid>
            ))}
          </Grid>
          {/* <button className="btn btn-danger btn-lg btnDesocupar" type="button" onClick={props.onClearArray}>  Desocupar parcelas  </button> */}
          <button className="btn btn-success btn-lg btnGananciaActual" type="button" onClick={props.gananciaActual}>  Ver Ganancia Actual  </button>
        </Grid>
      </Grid>
    </div>
  );
}