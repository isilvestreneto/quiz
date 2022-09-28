import { Component, OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { Perguntas } from '../model/perguntas';
import { PerguntasService } from './services/perguntas.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../shared/components/error-dialog/error-dialog.component';
import { ThemePalette } from '@angular/material/core';
import { ProgressSpinnerMode } from '@angular/material/progress-spinner';
import { PerguntaDialogComponent } from '../shared/components/pergunta-dialog/pergunta-dialog.component';

@Component({
  selector: 'perguntas',
  templateUrl: './perguntas.component.html',
  styleUrls: ['./perguntas.component.scss'],
})
export class PerguntasComponent implements OnInit {
  color: ThemePalette = 'accent';
  mode: ProgressSpinnerMode = 'indeterminate';
  value = 50;

  displayedColumns: string[] = ['id', 'titulo', 'botao'];

  clickedRows = new Set<Perguntas>();

  perguntas$: Observable<Perguntas[]>;

  constructor(
    private perguntasService: PerguntasService,
    public dialog: MatDialog
  ) {
    this.perguntas$ = this.perguntasService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar personagens.');
        return of([]);
      })
    );
  }

  openDialog(id: any) {
    const dialogRef = this.dialog.open(PerguntaDialogComponent);

    dialogRef.componentInstance.id = id;
    console.log(dialogRef.componentInstance.id);

    dialogRef.afterClosed().subscribe((result) => {
      // console.log(`Dialog result: ${result}`);
    });
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  ngOnInit(): void {}
}
