import {Component} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {serverUrl} from '../../../environments/environment';
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-upload',
  standalone: true,
  templateUrl: './upload.component.html',
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {

  uri = serverUrl + '/images';
  base64Data = '';
  message = '';

  uploadForm = new FormGroup({
    file: new FormControl('', [Validators.required]),
    data: new FormControl('', [Validators.required])
  });


  constructor(private httpClient: HttpClient) {
  }

  upload(): void {
    this.httpClient.post(this.uri, this.uploadForm.value)
      .subscribe({
          next: () => {
            this.uploadForm.reset();
            this.base64Data = "";
            this.message = 'Upload complete';
          },
          error: (msg) => console.log(msg)
        }
      );
  }

  onImageChange(e: any): void {
    const files: FileList = e.target.files;
    if (files && files.length > 0) {
      const reader = new FileReader();
      // @ts-ignore
      reader.readAsDataURL(files.item(0));
      reader.onload = () => {
        this.base64Data = reader.result as string;
        // @ts-ignore
        this.uploadForm.patchValue({data: reader.result});
      };
    }
  }


}
