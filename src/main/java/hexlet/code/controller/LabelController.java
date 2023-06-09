package hexlet.code.controller;

import hexlet.code.dto.LabelDto;
import hexlet.code.model.Label;
import hexlet.code.service.LabelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + LabelController.LABEL_CONTROLLER_PATH)
public class LabelController {

    public static final String ID = "/{id}";

    public static final String LABEL_CONTROLLER_PATH = "/labels";

    private final LabelService labelService;

    @Operation(summary = "Create new label")
    @ApiResponse(responseCode = "201", description = "Label created")
    @PostMapping
    @ResponseStatus(CREATED)
    public Label createStatus(@RequestBody @Valid final LabelDto dto) {
        return labelService.createNewLabel(dto);
    }


    @Operation(summary = "Get all labels")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = Label.class)),
            description = "Get all labels"
    ))
    @GetMapping
    public List<Label> getAll() {
        return labelService.getAllLabels();
    }


    @Operation(summary = "Retrieve label by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Label is found", content =
            @Content(schema = @Schema(implementation = Label.class))),
            @ApiResponse(responseCode = "404", description = "Label with this id is not found")})
    @GetMapping(ID)
    public Label getLabelById(@PathVariable final Long id) {
        return labelService.getLabelById(id);
    }


    @Operation(summary = "Update label by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Label is updated", content =
            @Content(schema = @Schema(implementation = Label.class))),
            @ApiResponse(responseCode = "404", description = "Label with this id is not found")})
    @PutMapping(ID)
    public Label update(@PathVariable final long id, @RequestBody @Valid final LabelDto dto) {
        return labelService.updateLabel(id, dto);
    }


    @Operation(summary = "Delete label by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Label is deleted", content =
            @Content(schema = @Schema(implementation = Label.class))),
            @ApiResponse(responseCode = "404", description = "Label with this id is not found")})
    @DeleteMapping(ID)
    public void delete(@PathVariable final long id) {
        labelService.deleteLabelById(id);
    }

}
