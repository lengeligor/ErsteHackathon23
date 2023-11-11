import {Component, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromState from "../../store/reducers";
import * as AppSelectors from "../../store/reducers/app.reducer";
import {Observable} from "rxjs";

interface Graph {
  mesiac: string;
  stav_uctu: number;
}

interface GraphData {
  graphType: string;
  graphs: Graph[];
}



@Component({
  selector: 'app-better-future',
  templateUrl: './better-future.component.html',
  styleUrls: ['./better-future.component.scss']
})
export class BetterFutureComponent implements OnInit{

  data: any;
  options: any;
  graphLoading$  = new Observable<boolean>();

  constructor(private store: Store<fromState.State>) {
  }

  financialData: any[] = [];
  ngOnInit(): void {
    this.graphLoading$ = this.store.select(AppSelectors.selectFinancialDataLoading)

    this.selectFinancialData();
    const documentStyle = getComputedStyle(document.documentElement);
    const textColor = documentStyle.getPropertyValue('--text-color');
    const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
    const surfaceBorder = documentStyle.getPropertyValue('--surface-border');



    this.options = {
      maintainAspectRatio: false,
      aspectRatio: 0.6,
      plugins: {
        legend: {
          labels: {
            color: textColor
          }
        }
      },
      scales: {
        x: {
          ticks: {
            color: textColorSecondary
          },
          grid: {
            color: surfaceBorder,
            drawBorder: false
          }
        },
        y: {
          ticks: {
            color: textColorSecondary
          },
          grid: {
            color: surfaceBorder,
            drawBorder: false
          }
        }
      }
    };
  }

  selectFinancialData(): void {
    this.store.select(AppSelectors.selectFinancialData).subscribe(data => {
      this.financialData=data;
      this.data = {
        labels: ['Nov', 'Dec', 'Jan', 'Feb', 'Mar', 'Apr'],
        datasets: this.createDatasets(data)
      };
      console.log(this.data)
    });
  }

  createDatasets(jsonData: GraphData[]) {
    console.log(jsonData)
    return jsonData.map(data => {
      return {
        label: data.graphType,
        data: data.graphs.map(graph => graph.stav_uctu),
        fill: false,
        borderColor: this.getBorderColor(data.graphType), // You need to define this function
        tension: 0.4
      };
    });
  }
  getBorderColor(graphType: string): string {
    const r = Math.floor(Math.random() * 256); // Red component
    const g = Math.floor(Math.random() * 256); // Green component
    const b = Math.floor(Math.random() * 256); // Blue component

    // Construct and return the color in hexadecimal format
    return `#${r.toString(16).padStart(2, '0')}${g.toString(16).padStart(2, '0')}${b.toString(16).padStart(2, '0')}`;

  }

}
