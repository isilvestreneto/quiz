import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs';
import { Perguntas } from 'src/app/model/perguntas';

@Injectable({
  providedIn: 'root',
})
export class PerguntasService {
  private readonly API = 'api/perguntas';

  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get<Perguntas[]>(this.API).pipe(
      first(),
      delay(500),
      // tap((perguntas) => console.log(perguntas))
    );
  }
}
